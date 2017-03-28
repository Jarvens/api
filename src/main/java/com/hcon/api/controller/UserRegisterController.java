package com.hcon.api.controller;

import com.hcon.api.domain.UserRegiter;
import io.swagger.annotations.Api;
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
@Api(value = "user",tags = "用户信息接口",description = "获取用户信息接口")
public class UserRegisterController {

    /**
     * 当前页码
     * 每页条数
     * 搜索关键字
     * @param eqlPage
     * @param key
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<UserRegiter> registerUserList(EqlPage eqlPage,String key){
        List<UserRegiter> userRegiterList = new ArrayList<>();
        return userRegiterList;
    }

}
