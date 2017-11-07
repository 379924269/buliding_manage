package com.dnp.bulidingmanage.shiro;

import com.dnp.bulidingmanage.model.Manager;
import com.dnp.bulidingmanage.model.Permission;
import com.dnp.bulidingmanage.service.ManagerService;
import com.dnp.bulidingmanage.service.PermissionService;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * shiro身份校验核心类
 *
 * @author 作者: z77z
 * @date 创建时间：2017年2月10日 下午3:19:48
 */

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = token.getUsername();
        Manager managerInfo = managerService.selectByAccout(username);
        if (managerInfo.getAccount() != null) {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, managerInfo.getPassword(), getName());
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("managerInfo", managerInfo);
            return simpleAuthenticationInfo;
        } else {
            throw new UnknownAccountException();
        }
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        if (StringUtils.isNotEmpty(username)) {
            List<Permission> permissionInfo = permissionService.findPermission(username);
            SimpleAuthorizationInfo sai = new SimpleAuthorizationInfo();
            for (Permission permission : permissionInfo) {
                sai.addStringPermission(permission.getPerKey());
            }
            return sai;
        }
        return null;
    }


    /**
     * 更新用户授权信息缓存.
     */
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 更新用户信息缓存.
     */
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    /**
     * 清除用户授权信息缓存.
     */
    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    /**
     * 清除用户信息缓存.
     */
    public void clearAllCachedAuthenticationInfo() {
        //getAuthenticationCache().clear();
    }

    /**
     * 清空所有缓存
     */
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    /**
     * 清空所有认证缓存
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
