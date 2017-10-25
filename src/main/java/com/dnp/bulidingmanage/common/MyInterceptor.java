package com.dnp.bulidingmanage.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器
 *
 * @Author 华仔
 * @Author 2017/10/16 10:03
 */
public class MyInterceptor extends HandlerInterceptorAdapter {
    Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        logger.info("==========" + session.getId());
        if (session.getAttribute("userId") != null) {
            logger.info("==================已经登陆================");
            return true;
        } else {
            //注意跳转的方法notLogin（）要为get
            response.sendRedirect(request.getContextPath() + "/manager/notLogin");
            return false;
        }
    }
}
