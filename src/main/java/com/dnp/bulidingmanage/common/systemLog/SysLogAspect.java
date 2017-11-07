package com.dnp.bulidingmanage.common.systemLog;

import com.dnp.bulidingmanage.model.Manager;
import com.dnp.bulidingmanage.model.SystemLog;
import com.dnp.bulidingmanage.service.SystemLogService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * aop记录操作日志， 日志描述根据自己的需求写
 *
 * @Author 华仔
 * @DATE 2017/11/6 13:43
 */
@Aspect
@Component
@Order
public class SysLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysLogAspect.class);

    @Autowired
    private SystemLogService systemLogService;

    /* 这个地方时更具自己写的注解来天，如果是controller，就找到controller注解的位置接可以了*/
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void cutController() {
    }

    @Around("cutController()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {
        String strMethodName = point.getSignature().getName();
        String strClassName = point.getTarget().getClass().getName();
        Object[] params = point.getArgs();
        StringBuilder bfParams = new StringBuilder();
        Enumeration<String> paraNames;
        HttpServletRequest request;
        request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if (params != null && params.length > 0) {
            paraNames = request.getParameterNames();
            String key;
            String value;
            while (paraNames.hasMoreElements()) {
                key = paraNames.nextElement();
                value = request.getParameter(key);
                bfParams.append(key).append("=").append(value).append("&");
            }
            if (StringUtils.isBlank(bfParams.toString())) {
                bfParams.append(request.getQueryString());
            }
        }

        String strMessage = String.format("[类名]:%s,[方法]:%s,[参数]:%s,[ip]:%s", strClassName, strMethodName, bfParams.toString(), request.getRemoteAddr());
        LOGGER.info("==requertUrl== {}", request.getRequestURL());
        LOGGER.info(strMessage);
        if (isWriteLog(request.getRequestURI())) {
            try {
                Subject currentUser = SecurityUtils.getSubject();
                PrincipalCollection collection = currentUser.getPrincipals();
                Manager manager = (Manager) SecurityUtils.getSubject().getSession().getAttribute("managerInfo");
                if (null != collection) {
                    SystemLog systemLog = new SystemLog();
                    systemLog.setManagerId(manager.getId());
                    systemLog.setManagerAccount(manager.getAccount());
                    systemLog.setManagerName(manager.getName());
                    systemLog.setDescription(strMessage);
                    systemLog.setClientIp(request.getRemoteAddr());
                    systemLog.setCreatedDate(System.currentTimeMillis());
                    systemLogService.insert(systemLog);
                    //插入日志
                }
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }

        return point.proceed();
    }

    /**
     * 需要记录日志的方法
     *
     * @param method 方法名称
     * @return boolean true：需要记录， false：不需要记录
     */
    private boolean isWriteLog(String method) {
        String[] pattern = {"building", "dept", "device", "inOutBuliding", "location", "manager", "login", "permission", "policy", "role"};
        for (String s : pattern) {
            if (method.contains(s)) {
                return true;
            }
        }
        return false;
    }

}
