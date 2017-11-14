package com.dnp.bulidingmanage.controller;

import com.dnp.bulidingmanage.model.RolePermission;
import com.dnp.bulidingmanage.service.RolePermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dnp.bulidingmanage.model.Role;
import com.dnp.bulidingmanage.service.RoleService;
import com.dnp.bulidingmanage.common.page.PageVo;

/**
 * <p>
 * 角色  前端控制器
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-25
 */
@Api(value = "Role", description = "角色")
@RestController
@RequestMapping(value = "/role", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有角色", notes = "查询所有角色")
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
        return null;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询角色详情", notes = "查询角色详情", httpMethod = "GET")
    public Role findById(@ApiParam(name = "id", value = "角色id", required = true) @PathVariable("id") Integer id) {
        return roleService.selectById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "修改角色", notes = "修改角色")
    public void update(Role role) {
        roleService.updateAllColumnById(role);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加角色", notes = "添加角色")
    public void save(
            @ApiParam(name = "name", value = "角色名称")
            @RequestParam(required = false, name = "name") String name
            ,
            @ApiParam(name = "allowDelete", value = "允许删除，0：不能删除，1：可以删除")
            @RequestParam(required = false, name = "allowDelete") Integer allowDelete
    ) {
        Role role = new Role(name, allowDelete);
        roleService.insertAllColumn(role);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除角色", notes = "修改角色")
    public void delete(@ApiParam(name = "id", value = "角色id", required = true) @PathVariable("id") Integer id) {
        roleService.deleteById(id);
    }


    @RequestMapping(value = "/addRolePermission", method = RequestMethod.POST)
    @ApiOperation(value = "添加角色权限", notes = "添加角色权限")
    public void addRolePermission(
            @ApiParam(name = "roleId", value = "角色Id")
            @RequestParam(required = false, name = "roleId") Integer roleId
            ,
            @ApiParam(name = "permissionId", value = "权限id")
            @RequestParam(required = false, name = "permissionId") Integer permissionId
    ) {
        rolePermissionService.insertRolePermission(new RolePermission(roleId, permissionId));
    }

    @RequestMapping(value = "/deleteRolePermission", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除角色权限", notes = "删除角色权限")
    public void deleteRolePermission(
            @ApiParam(name = "roleId", value = "角色Id")
            @RequestParam(required = false, name = "roleId") Integer roleId
            ,
            @ApiParam(name = "permissionId", value = "权限id")
            @RequestParam(required = false, name = "permissionId") Integer permissionId
    ) {
        rolePermissionService.deleteRolePermission(roleId, permissionId);
    }
}
