package com.hcon.api.controller;

import com.hcon.api.domain.UserRegister;
import com.hcon.api.service.UserRegisterService;
import com.hcon.common.DataRet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserRegisterService userRegisterService;

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
        boolean flag = userRegisterService.isRegister(userRegister.getAccount());
        if (flag) {

        } else {
            dataRet.setErrorCode("ACCOUNT_NOT_EXIST");
            dataRet.setMessage("账号或者密码错误请重新输入");
        }
        return dataRet;
    }

    /**
     * 退出系统
     *
     * @param userRegister
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ApiOperation(value = "注销登录", notes = "退出系统")
    @ApiImplicitParam(value = "用户信息", name = "userRegister", dataType = "UserRegister", required = true)
    public DataRet<String> logout(@RequestBody UserRegister userRegister) {
        return null;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/retry")
    public DataRet<String> retry() {
        DataRet<String> ret = new DataRet<>();
        ret.setMessage("请重新登录");
        ret.setErrorCode("RETRY_LOGIN");
        return ret;
    }
}
