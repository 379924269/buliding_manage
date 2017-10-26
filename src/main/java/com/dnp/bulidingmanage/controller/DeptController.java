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

import com.dnp.bulidingmanage.model.Dept;
import com.dnp.bulidingmanage.service.DeptService;
import com.dnp.bulidingmanage.common.page.PageVo;

/**
 * <p>
 * 部门信息  前端控制器
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-25
 */
@Api(value = "Dept", description = "部门信息")
@RestController
@RequestMapping(value = "/dept", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有部门信息", notes = "查询所有部门信息")
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
        return null;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询部门信息详情", notes = "查询部门信息详情", httpMethod = "GET")
    public Dept findById(@ApiParam(name = "id", value = "部门信息id", required = true) @PathVariable("id") Integer id) {
        return deptService.selectById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "修改部门信息", notes = "修改部门信息")
    public void update(Dept dept) {
        deptService.updateAllColumnById(dept);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加部门信息", notes = "添加部门信息")
    public void save(

            @ApiParam(name = "name", value = "部门名称")
            @RequestParam(required = false, name = "name") String name
            ,
            @ApiParam(name = "number", value = "部门编号")
            @RequestParam(required = false, name = "number") String number
            ,
            @ApiParam(name = "parentId", value = "父部门ID")
            @RequestParam(required = false, name = "parentId") Integer parentId
    ) {
        Dept dept = new Dept(

                name, number, parentId);
        deptService.insertAllColumn(dept);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除部门信息", notes = "修改部门信息")
    public void delete(@ApiParam(name = "id", value = "部门信息id", required = true) @PathVariable("id") Integer id) {
        deptService.deleteById(id);
    }

}
