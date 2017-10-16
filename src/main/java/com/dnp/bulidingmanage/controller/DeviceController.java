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

import com.dnp.bulidingmanage.model.Device;
import com.dnp.bulidingmanage.service.DeviceService;
import com.dnp.bulidingmanage.common.page.PageVo;

/**
 * <p>
 * 手机的一些信息  前端控制器
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-11
 */
@Api(value = "DeviceController", description = "手机的一些信息")
@RestController
@RequestMapping(value = "/device", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有手机的一些信息", notes = "查询所有手机的一些信息")
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
        return null;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询手机的一些信息详情", notes = "查询手机的一些信息详情", httpMethod = "GET")
    public Device findById(@ApiParam(name = "id", value = "手机的一些信息id", required = true) @PathVariable("id") Integer id) {
        return deviceService.selectById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "修改手机的一些信息", notes = "修改手机的一些信息")
    public void update(Device device) {
        deviceService.updateAllColumnById(device);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加手机的一些信息", notes = "添加手机的一些信息")
    public void save(

            @ApiParam(name = "imei", value = "imei")
            @RequestParam(required = false, name = "imei") String imei
            ,
            @ApiParam(name = "imsi", value = "imsi")
            @RequestParam(required = false, name = "imsi") String imsi
            ,
            @ApiParam(name = "imfi", value = "imfi")
            @RequestParam(required = false, name = "imfi") String imfi
            ,
            @ApiParam(name = "phone", value = "号码")
            @RequestParam(required = false, name = "phone") String phone
    ) {
        Device device = new Device(

                imei, imsi, imfi, phone);
        deviceService.insertAllColumn(device);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除手机的一些信息", notes = "修改手机的一些信息")
    public void delete(@ApiParam(name = "id", value = "手机的一些信息id", required = true) @PathVariable("id") Integer id) {
        deviceService.deleteById(id);
    }

}
