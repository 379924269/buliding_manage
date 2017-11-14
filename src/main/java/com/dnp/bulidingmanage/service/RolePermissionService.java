package com.dnp.bulidingmanage.service;

import com.dnp.bulidingmanage.model.RolePermission;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 角色权限关系表 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-25
 */
public interface RolePermissionService extends IService<RolePermission> {
    void  insertRolePermission(RolePermission rolePermission);
    void  deleteRolePermission(int roleId, int permissionId);
}
