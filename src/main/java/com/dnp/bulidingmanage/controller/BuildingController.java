package

        com.dnp.bulidingmanage.controller;

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

import com.dnp.bulidingmanage.model.Building;
import com.dnp.bulidingmanage.service.BuildingService;
import com.dnp.bulidingmanage.common.page.PageVo;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-11
 */
@Api(value = "BuildingController", description = "")
@RestController
@RequestMapping(value = "/building", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有", notes = "查询所有")
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
        return null;
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
            @RequestParam(required = false, name = "name") String name
            ,
            @ApiParam(name = "number", value = "大楼编号")
            @RequestParam(required = false, name = "number") String number
            ,
            @ApiParam(name = "policyId", value = "开关功能id")
            @RequestParam(required = false, name = "policyId") Integer policyId
    ) {
        Building building = new Building(

                name, number, policyId);
        buildingService.insertAllColumn(building);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除", notes = "修改")
    public void delete(@ApiParam(name = "id", value = "id", required = true) @PathVariable("id") Integer id) {
        buildingService.deleteById(id);
    }

}
