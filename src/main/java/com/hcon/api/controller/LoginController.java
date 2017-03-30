package com.hcon.api.controller;

import com.alibaba.fastjson.JSON;
import com.hcon.api.domain.UserRegister;
import com.hcon.api.service.UserRegisterService;
import com.hcon.common.DataRet;
import com.hcon.utils.LoginHelper;
import com.hcon.utils.TokenUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by kunlun on 2017/3/29.
 */
@RestController
@RequestMapping("sys")
@Api(value = "登录接口列表", tags = "登录接口", description = "系统登录")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

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
    public DataRet<String> login(@RequestBody UserRegister userRegister,HttpServletResponse response) {
        DataRet<String> dataRet = new DataRet<>();
        boolean flag = userRegisterService.isRegister(userRegister.getAccount());
        if (flag) {
            //生成Token
            String tokenVal = TokenUtils.createToken(userRegister);
            //写cookie
            //LoginHelper.sysLoginSuccess(response, userRegister, false);
            //更新系统时间
            userRegister.updateCurrentTime();
            dataRet.setMessage("登录成功");
            dataRet.setBody(tokenVal);
        } else {
            dataRet.setErrorCode("ACCOUNT_PASSWORD_ERROR");
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
     * @return
     */
    @ApiIgnore
    @RequestMapping(value = "/retry")
    public DataRet<String> retry() {
        DataRet<String> ret = new DataRet<>();
        ret.setMessage("请重新登录");
        ret.setErrorCode("RETRY_LOGIN");
        return ret;
    }
}
