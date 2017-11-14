package com.dnp.bulidingmanage.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dnp.bulidingmanage.model.RolePermission;
import com.dnp.bulidingmanage.dao.RolePermissionMapper;
import com.dnp.bulidingmanage.service.RolePermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dnp.bulidingmanage.shiro.MyShiroRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色权限关系表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-25
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public void insertRolePermission(RolePermission rolePermission) {
        rolePermissionMapper.insert(rolePermission);
        //这个只是让当前的用户权限重置，但其他用户没有重置，没什么卵用
        //RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        //MyShiroRealm userRealm = (MyShiroRealm) securityManager.getRealms().iterator().next();
        //userRealm.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }

    @Override
    public void deleteRolePermission(int roleId, int permissionId) {
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("role_id", roleId);
        entityWrapper.eq("permission_id", permissionId);
        rolePermissionMapper.delete(entityWrapper);
    }
}
