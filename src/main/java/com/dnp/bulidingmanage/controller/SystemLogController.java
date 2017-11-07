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

import com.dnp.bulidingmanage.model.SystemLog;
import com.dnp.bulidingmanage.service.SystemLogService;
import com.dnp.bulidingmanage.common.page.PageVo;

/**
 * <p>
 * 系统日志
 * </p>
 *
 * @author stylefeng
 * @since 2017-11-06
 */
@Api(value = "SystemLogController", description = "系统日志")
@RestController
@RequestMapping(value = "/systemLog", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SystemLogController {
    @Autowired
    private SystemLogService systemLogService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有系统日志", notes = "查询所有系统日志")
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search", value = "模糊查询字段") @RequestParam(required = false, defaultValue = "") String search) {
        return systemLogService.findAllLog(pageVo, search);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询系统日志详情", notes = "查询系统日志详情", httpMethod = "GET")
    public SystemLog findById(@ApiParam(name = "id", value = "系统日志id", required = true) @PathVariable("id") Integer id) {
        return systemLogService.selectById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "修改系统日志", notes = "修改系统日志")
    public void update(SystemLog systemLog) {
        systemLogService.updateAllColumnById(systemLog);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加系统日志", notes = "添加系统日志")
    public void save(
            @ApiParam(name = "managerId", value = "管理员id")
            @RequestParam(required = false, name = "managerId") Integer managerId,
            @ApiParam(name = "managerName", value = "管理员名称")
            @RequestParam(required = false, name = "managerName") String managerName,
            @ApiParam(name = "managerAccount", value = "管理员账号")
            @RequestParam(required = false, name = "managerAccount") String managerAccount,
            @ApiParam(name = "description", value = "日志描述")
            @RequestParam(required = false, name = "description") String description,
            @ApiParam(name = "createdDate", value = "创建时间")
            @RequestParam(required = false, name = "createdDate") Long createdDate,
            @ApiParam(name = "clientIp", value = "客户端IP")
            @RequestParam(required = false, name = "clientIp") String clientIp,
            @ApiParam(name = "createTime", value = "创建时间")
            @RequestParam(required = false, name = "createTime") Long createTime
    ) {
        SystemLog systemLog = new SystemLog(managerId, managerName, managerAccount, description, createdDate, clientIp);
        systemLogService.insertAllColumn(systemLog);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除系统日志", notes = "修改系统日志")
    public void delete(@ApiParam(name = "id", value = "系统日志id", required = true) @PathVariable("id") Integer id) {
        systemLogService.deleteById(id);
    }

}
