package com.dnp.bulidingmanage.service;

import com.dnp.bulidingmanage.model.Manager;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 管理员表 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-11
 */
public interface ManagerService extends IService<Manager> {
    /**
     * 通过名称获取管理员信息
     *
     * @param account 登陆名称
     * @return Manager manager 实体类
     */
    Manager selectByAccout(String account);

    /**
     * 通过管理员名称获取管理员角色（多个用逗号隔开）
     *
     * @param account 管理员登陆名称
     * @return stirng 角色ids
     */
    String selectRoleIds(String account);
}
