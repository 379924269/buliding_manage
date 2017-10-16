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

import com.dnp.bulidingmanage.model.Policy;
import com.dnp.bulidingmanage.service.PolicyService;
import com.dnp.bulidingmanage.common.page.PageVo;

/**
 * <p>
 * 进出大楼要开关的一些功能策略  前端控制器
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-11
 */
@Api(value = "PolicyController", description = "进出大楼要开关的一些功能策略")
@RestController
@RequestMapping(value = "/policy", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PolicyController {
    @Autowired
    private PolicyService policyService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有进出大楼要开关的一些功能策略", notes = "查询所有进出大楼要开关的一些功能策略")
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
        return null;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询进出大楼要开关的一些功能策略详情", notes = "查询进出大楼要开关的一些功能策略详情", httpMethod = "GET")
    public Policy findById(@ApiParam(name = "id", value = "进出大楼要开关的一些功能策略id", required = true) @PathVariable("id") Integer id) {
        return policyService.selectById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "修改进出大楼要开关的一些功能策略", notes = "修改进出大楼要开关的一些功能策略")
    public void update(Policy policy) {
        policyService.updateAllColumnById(policy);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加进出大楼要开关的一些功能策略", notes = "添加进出大楼要开关的一些功能策略")
    public void save(

            @ApiParam(name = "name", value = "策略名称")
            @RequestParam(required = false, name = "name") String name
            ,
            @ApiParam(name = "content", value = "开关功能")
            @RequestParam(required = false, name = "content") String content
    ) {
        Policy policy = new Policy(

                name, content);
        policyService.insertAllColumn(policy);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除进出大楼要开关的一些功能策略", notes = "修改进出大楼要开关的一些功能策略")
    public void delete(@ApiParam(name = "id", value = "进出大楼要开关的一些功能策略id", required = true) @PathVariable("id") Integer id) {
        policyService.deleteById(id);
    }

}
