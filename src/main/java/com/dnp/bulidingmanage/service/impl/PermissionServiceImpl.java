package com.dnp.bulidingmanage.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dnp.bulidingmanage.dao.ManagerMapper;
import com.dnp.bulidingmanage.dao.PermissionMapper;
import com.dnp.bulidingmanage.model.Manager;
import com.dnp.bulidingmanage.model.Permission;
import com.dnp.bulidingmanage.model.RolePermission;
import com.dnp.bulidingmanage.service.ManagerService;
import com.dnp.bulidingmanage.service.PermissionService;
import com.dnp.bulidingmanage.service.RolePermissionService;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private RolePermissionService rolePermissionService;


    @Override
    public List<Permission> findPermission(String managerName) {
        //获取角色id
        String roleIds = managerService.selectRoleIds(managerName);
        //获取所有权限id
        EntityWrapper entityWrapper = new EntityWrapper<RolePermission>();
        entityWrapper.in("role_id", roleIds);
        List<RolePermission> rolePermissionList = rolePermissionService.selectList(entityWrapper);
        JSONArray permissionJsonArray = new JSONArray();
        for (RolePermission rolePermission : rolePermissionList) {
            permissionJsonArray.put(rolePermission.getPermissionId());
        }

        //获取所有权限信息
        if (permissionJsonArray.length() == 0) {
            return new ArrayList<>();
        }
        EntityWrapper getpermissMapper = new EntityWrapper();
        getpermissMapper.in("id", StringUtils.substring(permissionJsonArray.toString(), 1,permissionJsonArray.toString().length() -1));
        return permissionMapper.selectList(getpermissMapper);
    }
}
