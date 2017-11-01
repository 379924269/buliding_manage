package

        com.dnp.bulidingmanage.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
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

import com.dnp.bulidingmanage.model.Permission;
import com.dnp.bulidingmanage.service.PermissionService;
import com.dnp.bulidingmanage.common.page.PageVo;

/**
 * <p>
 * 权限信息  前端控制器
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-26
 */
@Api(value = "PermissionController", description = "权限信息")
@RestController
@RequestMapping(value = "/permission", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有权限信息", notes = "查询所有权限信息")
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
        return permissionService.selectList(new EntityWrapper<Permission>());
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询权限信息详情", notes = "查询权限信息详情", httpMethod = "GET")
    public Permission findById(@ApiParam(name = "id", value = "权限信息id", required = true) @PathVariable("id") Integer id) {
        return permissionService.selectById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "修改权限信息", notes = "修改权限信息")
    public void update(Permission permission) {
        permissionService.updateAllColumnById(permission);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加权限信息", notes = "添加权限信息")
    public void save(

            @ApiParam(name = "name", value = "url描述")
            @RequestParam(required = false, name = "name") String name
            ,
            @ApiParam(name = "parentId", value = "父节点id")
            @RequestParam(required = false, name = "parentId") Integer parentId
            ,
            @ApiParam(name = "perUrl", value = "请求地址")
            @RequestParam(required = false, name = "perUrl") String perUrl
            ,
            @ApiParam(name = "perKey", value = "权限key")
            @RequestParam(required = false, name = "perKey") String perKey
            ,
            @ApiParam(name = "type", value = "")
            @RequestParam(required = false, name = "type") Integer type
    ) {
        Permission permission = new Permission(

                name, parentId, perUrl, perKey, type);
        permissionService.insertAllColumn(permission);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除权限信息", notes = "修改权限信息")
    public void delete(@ApiParam(name = "id", value = "权限信息id", required = true) @PathVariable("id") Integer id) {
        permissionService.deleteById(id);
    }

}
