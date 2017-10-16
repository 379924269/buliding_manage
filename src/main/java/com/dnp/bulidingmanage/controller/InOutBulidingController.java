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

import com.dnp.bulidingmanage.model.InOutBuliding;
import com.dnp.bulidingmanage.service.InOutBulidingService;
import com.dnp.bulidingmanage.common.page.PageVo;

/**
 * <p>
 * 记录手机进出大楼的一些信息  前端控制器
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-11
 */
@Api(value = "InOutBulidingController", description = "记录手机进出大楼的一些信息")
@RestController
@RequestMapping(value = "/inOutBuliding", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class InOutBulidingController {
    @Autowired
    private InOutBulidingService inOutBulidingService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有记录手机进出大楼的一些信息", notes = "查询所有记录手机进出大楼的一些信息")
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
        return null;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询记录手机进出大楼的一些信息详情", notes = "查询记录手机进出大楼的一些信息详情", httpMethod = "GET")
    public InOutBuliding findById(@ApiParam(name = "id", value = "记录手机进出大楼的一些信息id", required = true) @PathVariable("id") Integer id) {
        return inOutBulidingService.selectById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "修改记录手机进出大楼的一些信息", notes = "修改记录手机进出大楼的一些信息")
    public void update(InOutBuliding inOutBuliding) {
        inOutBulidingService.updateAllColumnById(inOutBuliding);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加记录手机进出大楼的一些信息", notes = "添加记录手机进出大楼的一些信息")
    public void save(

            @ApiParam(name = "bulidingId", value = "大楼id")
            @RequestParam(required = false, name = "bulidingId") Integer bulidingId
            ,
            @ApiParam(name = "deviceId", value = "手机id")
            @RequestParam(required = false, name = "deviceId") Integer deviceId
            ,
            @ApiParam(name = "inTime", value = "进入大楼时间")
            @RequestParam(required = false, name = "inTime") Long inTime
            ,
            @ApiParam(name = "outTime", value = "出大楼时间")
            @RequestParam(required = false, name = "outTime") Long outTime
            ,
            @ApiParam(name = "legal", value = "手机验证是否通过,1：合法，0：不合法")
            @RequestParam(required = false, name = "legal") Integer legal
    ) {
        InOutBuliding inOutBuliding = new InOutBuliding(

                bulidingId, deviceId, inTime, outTime, legal);
        inOutBulidingService.insertAllColumn(inOutBuliding);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除记录手机进出大楼的一些信息", notes = "修改记录手机进出大楼的一些信息")
    public void delete(@ApiParam(name = "id", value = "记录手机进出大楼的一些信息id", required = true) @PathVariable("id") Integer id) {
        inOutBulidingService.deleteById(id);
    }

}
