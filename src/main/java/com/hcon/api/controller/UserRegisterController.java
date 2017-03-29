package com.hcon.api.controller;

import com.hcon.api.domain.UserRegiter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.n3r.eql.EqlPage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kunlun on 2017/3/28.
 */
@RequestMapping("user")
@RestController
@Api(value = "user", tags = "用户信息接口", description = "获取用户信息接口")
public class UserRegisterController {

    /**
     * 当前页码
     * 每页条数
     * 搜索关键字
     *
     * @param eqlPage
     * @param key
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation(value = "用户集合", notes = "根据搜索关键字查询用户信息并分页")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "eqlPage", name = "分页", required = true, dataType = "eqlPage"),
            @ApiImplicitParam(value = "key", name = "搜搜关键字", dataType = "String")
    })
    public List<UserRegiter> registerUserList(EqlPage eqlPage, String key) {
        List<UserRegiter> userRegiterList = new ArrayList<>();
        return userRegiterList;
    }

}
