package com.hcon.api.controller;

import com.hcon.api.domain.SysUser;
import com.hcon.api.service.UserRegisterService;
import com.hcon.core.common.DataRet;
import com.hcon.utils.Redis;
import com.hcon.utils.TokenUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by kunlun on 2017/3/29.
 */
@RestController
@RequestMapping("sys")
@Api(value = "登录接口列表")
public class LoginController {

    @Autowired
    private UserRegisterService userRegisterService;

    /**
     * 登录
     *
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录", notes = "用户登录")
    @ApiImplicitParam(value = "用户信息", name = "sysUser", dataType = "SysUser", required = true)
    public DataRet<String> login(@RequestBody SysUser sysUser, HttpServletResponse response) {
        DataRet<String> dataRet = new DataRet<>();
        String value = Redis.get("key1");
        if (StringUtils.isEmpty(sysUser.getAccount()) || StringUtils.isEmpty(sysUser.getPassword())) {
            return this.result(dataRet, "password_error", "用户名或密码错误");
        }
        boolean flag = userRegisterService.login(sysUser);
        if (flag) {
            //生成Token
            String tokenVal = TokenUtils.createToken(sysUser);
            //更新系统时间
            sysUser.updateCurrentTime();
            dataRet.setMessage("登录成功");
            dataRet.setBody(tokenVal);
            return dataRet;
        } else {
            return this.result(dataRet, "account_password_error", "账号或密码错误请重新输入");
        }
    }

    /**
     * 退出系统
     *
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ApiOperation(value = "退出系统", notes = "退出系统")
    @ApiImplicitParam(value = "用户信息", name = "userRegister", dataType = "UserRegister", required = true)
    public DataRet<String> logout(@RequestBody SysUser sysUser) {

        return null;
    }


    /**
     * @param errorCode
     * @param message
     * @return
     */
    private DataRet<String> result(DataRet<String> ret, String errorCode, String message) {
        ret.setErrorCode(errorCode);
        ret.setMessage(message);
        return ret;
    }
}
