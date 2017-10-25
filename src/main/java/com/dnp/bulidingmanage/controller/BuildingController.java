package com.dnp.bulidingmanage.controller;

import com.dnp.bulidingmanage.common.LogUtil;
import com.dnp.bulidingmanage.common.page.PageVo;
import com.dnp.bulidingmanage.common.swagger.ResponsePageResult.BuilidingPageResult;
import com.dnp.bulidingmanage.common.swagger.ResponsePageResult.BuilidingRelationPageResult;
import com.dnp.bulidingmanage.model.Building;
import com.dnp.bulidingmanage.service.BuildingService;
import com.dnp.bulidingmanage.vo.ResponseJsonVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-11
 */
@Api(value = "Building", description = "大楼信息")
@RestController
@RequestMapping(value = "/building", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@ApiResponses(value = {@ApiResponse(code = 1000, message = "没有登陆", response = ResponseJsonVo.class)})
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有", notes = "查询所有", response = BuilidingPageResult.class)
    public Object findAll(PageVo pageVo, @ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
        return buildingService.findAll(pageVo, search);
    }

    @RequestMapping(value = "/findAllRelation", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有关联信息", notes = "查询所有关联信息", response = BuilidingRelationPageResult.class)
    public Object findAllRelation(PageVo pageVo,
                                  @ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
        LogUtil.info(this, "==========findAll=============");
        return buildingService.findAllRelation(pageVo, search);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询详情", notes = "查询详情", httpMethod = "GET")
    public Building findById(@ApiParam(name = "id", value = "id", required = true) @PathVariable("id") Integer id) {
        return buildingService.selectById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "修改", notes = "修改")
    public void update(Building building) {
        buildingService.updateAllColumnById(building);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加", notes = "添加")
    public void save(
            @ApiParam(name = "name", value = "大楼名称")
            @RequestParam(required = false, name = "name") String name,
            @ApiParam(name = "number", value = "大楼编号")
            @RequestParam(required = false, name = "number") String number,
            @ApiParam(name = "policyId", value = "开关功能id")
            @RequestParam(required = false, name = "policyId") Integer policyId) {
        Building building = new Building(name, number, policyId);
        buildingService.insertAllColumn(building);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除", notes = "修改")
    public void delete(@ApiParam(name = "id", value = "id", required = true) @PathVariable("id") Integer id) {
        buildingService.deleteById(id);

    }

}
