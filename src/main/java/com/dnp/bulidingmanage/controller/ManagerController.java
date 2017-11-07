package com.dnp.bulidingmanage.controller;

import com.dnp.bulidingmanage.common.page.PageVo;
import com.dnp.bulidingmanage.model.Manager;
import com.dnp.bulidingmanage.service.ManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 管理员表  前端控制器
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-11
 */
@Api(value = "Manager", description = "管理员表")
@RestController
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有管理员表", notes = "查询所有管理员表")
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search", value = "模糊查询字段") @RequestParam(required = false, defaultValue = "") String search) {
        return null;
    }


    @RequestMapping(value = "/manager/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询管理员表详情", notes = "查询管理员表详情", httpMethod = "GET")
    public Manager findById(@ApiParam(name = "id", value = "管理员表id", required = true) @PathVariable("id") Integer id) {
        return managerService.selectById(id);
    }

    @RequestMapping(value = "/manager/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "修改管理员表", notes = "修改管理员表")
    public void update(Manager manager) {
        managerService.updateAllColumnById(manager);
    }

    @RequestMapping(value = "/manager", method = RequestMethod.POST)
    @ApiOperation(value = "添加管理员表", notes = "添加管理员表")
    public void save(
            @ApiParam(name = "name", value = "管理员名")
            @RequestParam(required = false, name = "name") String name
            ,
            @ApiParam(name = "account", value = "管理员账号")
            @RequestParam(required = false, name = "account") String account
            ,
            @ApiParam(name = "password", value = "管理员密码")
            @RequestParam(required = false, name = "password") String password
            ,
            @ApiParam(name = "createdDate", value = "创建时间")
            @RequestParam(required = false, name = "createdDate") Long createdDate
            ,
            @ApiParam(name = "allowDeleted", value = "删除，1：允许，0：不允许")
            @RequestParam(required = false, name = "allowDeleted") Integer allowDeleted
            ,
            @ApiParam(name = "salt", value = "md5密码盐")
            @RequestParam(required = false, name = "salt") String salt
            ,
            @ApiParam(name = "deptId", value = "部门id")
            @RequestParam(required = false, name = "deptId") Integer deptId
            ,
            @ApiParam(name = "status", value = "状态，1：启用，2：冻结，3：删除")
            @RequestParam(required = false, name = "status") Integer status
    ) {
        Manager manager = new Manager(name, account, password, createdDate, allowDeleted, salt, deptId, status);
        managerService.insertAllColumn(manager);
    }

    @RequestMapping(value = "/manager/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除管理员表", notes = "修改管理员表")
    public void delete(@ApiParam(name = "id", value = "管理员表id", required = true) @PathVariable("id") Integer id) {
        managerService.deleteById(id);
    }
}
