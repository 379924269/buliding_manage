package com.dnp.bulidingmanage.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dnp.bulidingmanage.model.Permission;
import com.dnp.bulidingmanage.dao.PermissionMapper;
import com.dnp.bulidingmanage.service.ManagerService;
import com.dnp.bulidingmanage.service.PermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限信息 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-26
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Autowired
    private  PermissionMapper permissionMapper;

    @Autowired
    private ManagerService managerService;

    @Override
    public List<Permission> findPermission(String managerName) {
        String roleIds = managerService.selectRoleIds(managerName);
        managerService.selectRoleIds(managerName);
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.in("id", roleIds);
        return permissionMapper.selectList(entityWrapper);
    }
}
