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
     * 通过管理员登录名称获取管理员拥有的所有权限
     *
     * @param managerName 管理员名称
     * @return List<Permission> 权限集合,没有返回new Arraylist()
     */
    List<Permission> findPermission(String managerName);
}
