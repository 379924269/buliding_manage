package com.dnp.bulidingmanage.service;

import com.dnp.bulidingmanage.model.Permission;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 权限信息 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-26
 */
public interface PermissionService extends IService<Permission> {

    /**
     * 通过管理员登录名称获取管理员权限
     *
     * @param managerName 一个或多个角色id
     * @return List<Permission> 权限集合
     */
    List<Permission> findPermission(String managerName);
}
