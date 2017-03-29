package com.hcon.api.controller;

import com.hcon.api.domain.UserRegister;
import com.hcon.common.DataRet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kunlun on 2017/3/29.
 */
@RestController
@RequestMapping("sys")
@Api(value = "登录接口列表", tags = "登录接口", description = "系统登录")
public class LoginController {

    /**
     * 登录
     *
     * @param userRegister
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录", notes = "用户登录")
    @ApiImplicitParam(value = "用户信息", name = "userRegister", dataType = "UserRegister", required = true)
    public DataRet<String> login(@RequestBody UserRegister userRegister) {
        DataRet<String> dataRet = new DataRet<>();
        return dataRet;
    }

    /**
     * 退出系统
     * @param userRegister
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    @ApiOperation(value = "注销登录",notes = "退出系统")
    @ApiImplicitParam(value = "用户信息",name = "userRegister",dataType = "UserRegister",required = true)
    public DataRet<String> logout(@RequestBody UserRegister userRegister){
        return null;
    }
}
