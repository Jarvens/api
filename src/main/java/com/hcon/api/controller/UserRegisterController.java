package com.hcon.api.controller;

import com.hcon.api.domain.UserRegister;
import com.hcon.api.service.UserRegisterService;
import com.hcon.common.DataRet;
import com.hcon.common.GridDataRet;
import com.hcon.interceptor.login.annotations.LoginVerifyAction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.n3r.eql.EqlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kunlun on 2017/3/28.
 */
@LoginVerifyAction
@RequestMapping("user")
@RestController
@Api(value = "用户接口列表", tags = "用户信息接口", description = "获取用户信息接口")
public class UserRegisterController {

    @Autowired
    private UserRegisterService userRegisterService;

    /**
     * 查询用户信息并分页
     *
     * @param eqlPage
     * @param key
     * @return
     */

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户信息", notes = "根据搜索关键字查询用户信息并分页")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "当前页", name = "currentPage", required = true, dataType = "Integer"),
            @ApiImplicitParam(value = "每页条数", name = "pageRows", required = true, dataType = "Integer"),
            @ApiImplicitParam(value = "搜索关键字", name = "key", dataType = "string")
    })
    public GridDataRet<UserRegister> registerUserList(EqlPage eqlPage, String key) {
        GridDataRet<UserRegister> gridDataRet = new GridDataRet<>();
        List<UserRegister> userRegisterList = new ArrayList<>();
        userRegisterList = userRegisterService.queryUserByCondition(eqlPage, key);
        gridDataRet.setList(userRegisterList);
        gridDataRet.setPage(eqlPage.getTotalPages());
        gridDataRet.setSize(eqlPage.getPageRows());
        gridDataRet.setTotal(eqlPage.getTotalRows());
        return gridDataRet;
    }


    /**
     * 注册用户
     *
     * @param userRegister
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "注册用户信息", notes = "平台用户注册")
    @ApiImplicitParam(name = "userRegister", value = "用户对象", dataType = "UserRegister", required = true)
    public DataRet<String> register(@RequestBody UserRegister userRegister) {
        DataRet<String> ret = new DataRet<>();
        ret.setMessage("用户已存在");
        ret.setErrorCode("ACCOUNT_EXIST");
        return ret;
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(value = "删除用户信息", notes = "根据用户id删除用户信息")
    @ApiImplicitParam(value = "用户id", name = "id", dataType = "Long", required = true)
    public DataRet<String> del(Long id) {
        DataRet<String> ret = new DataRet<>();
        return ret;
    }

    /**
     * 更新用户信息
     *
     * @param userRegister
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @ApiImplicitParam(value = "用户对象", name = "userRegister", dataType = "UserRegister", required = true)
    public DataRet<String> update(@RequestBody UserRegister userRegister) {
        DataRet<String> ret = new DataRet<>();
        return ret;
    }

    /**
     * 修改密码
     *
     * @param id
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @RequestMapping(value = "/update-password", method = RequestMethod.POST)
    @ApiOperation(value = "修改用户密码", notes = "修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户id", name = "id", dataType = "Long", required = true),
            @ApiImplicitParam(value = "原始密码", name = "oldPassword", dataType = "String", required = true),
            @ApiImplicitParam(value = "新密码", name = "newPassword", dataType = "String", required = true)
    })
    public DataRet<String> updatePassword(Long id, String oldPassword, String newPassword) {
        DataRet<String> ret = new DataRet<>();
        return ret;
    }

}
