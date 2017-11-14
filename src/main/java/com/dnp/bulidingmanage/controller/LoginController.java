package com.dnp.bulidingmanage.controller;

import com.dnp.bulidingmanage.common.LogUtil;
import com.dnp.bulidingmanage.vo.ResponseJsonVo;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 管理员表  前端控制器
 * </p>
 *
 * @author stylefeng
 * @since 2017-10-11
 */
@Api(value = "login", description = "登录退出")
@RestController
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class LoginController {
    @RequestMapping(value = "/login/notLogin")
    @ApiOperation(value = "没有登录", notes = "没有登录", hidden = true)
    public Object notLogin() {
        //return new ResponseJsonVo(1000, false, "没有登陆");
        LogUtil.info(this, "没有登陆");
        return new ResponseJsonVo(200, false, "没有登陆");
    }

    @RequestMapping(value = "/login/noPermission")
    @ApiOperation(value = "没有权限", notes = "没有权限", hidden = true)
    public Object noPermission(HttpServletResponse response) {
        //return new ResponseJsonVo(1000, false, "没有登陆");
        LogUtil.info(this, "没有权限");
        response.setStatus(403);
        return new ResponseJsonVo(403, false, "没有权限");
    }

    @RequestMapping(value = "login/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录", notes = "登录")
    @ApiResponses({@ApiResponse(code = 2004, message = "用户已经被锁定不能登录,请与管理员联系!"),
            @ApiResponse(code = 2005, message = "登录失败次数过多,锁定10分钟!"),
            @ApiResponse(code = 2005, message = "用户或密码不正确！")})
    public Object login(HttpServletResponse response, @ApiParam(name = "userName", value = "用户名称", required = true, defaultValue = "test1") @RequestParam String userName, @ApiParam(name = "password", value = "用户密码",
            defaultValue = "123456", required = true) @RequestParam String password) {
        Subject manager = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            manager.login(token);
        } catch (LockedAccountException lae) {
            token.clear();
            response.setStatus(2004);
            return new ResponseJsonVo(2004, false, "用户已经被锁定不能登录,请与管理员联系！");
        } catch (ExcessiveAttemptsException e) {
            token.clear();
            response.setStatus(2005);
            return new ResponseJsonVo(2005, false, "登录失败次数过多,锁定10分钟!");
        } catch (AuthenticationException e) {
            token.clear();
            response.setStatus(2006);
            return new ResponseJsonVo(2006, false, "用户或密码不正确！");

        }

        LogUtil.info(this, "登录成功");

        //request.getSession().setAttribute("userId", "1");
        return new ResponseJsonVo(200, true, "登陆成功");
    }

    @RequestMapping(value = "/login/loginOut")
    @ApiOperation(value = "退出", notes = "退出", hidden = true, response = ResponseJsonVo.class)
    public Object loginOut() {
        SecurityUtils.getSubject().logout();
        return new ResponseJsonVo(200, true, "退出成功");
    }

    @RequestMapping(value = "/login/kickout")
    @ApiOperation(value = "并发用户登录踢出", notes = "并发用户登录踢出", hidden = true, response = ResponseJsonVo.class)
    public Object kickout() {
        return new ResponseJsonVo(666, false, "其他用户登录该账号，已经被强制踢出");
    }

    @RequestMapping(value = "/")
    @ApiOperation(value = "/", hidden = true)
    public void start(HttpServletResponse response) {
        try {
            //不知道为什么找不到跳转回一直循环
            response.sendRedirect("/buliding/swagger-ui.html#/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
