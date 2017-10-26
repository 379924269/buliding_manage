package com.dnp.bulidingmanage.dao;

import com.dnp.bulidingmanage.model.Manager;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 管理员表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-11
 */
public interface ManagerMapper extends BaseMapper<Manager> {
    /**
     * 通过管理员名称获取管理员角色（多个用逗号隔开）
     *
     * @param account 管理员登陆名称
     * @return stirng 角色ids
     */
    List<Map<String, Object>> selectRoleIds(@Param("account") String account);
}