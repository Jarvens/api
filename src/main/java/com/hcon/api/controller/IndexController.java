package com.hcon.api.controller;

import com.hcon.api.service.UserService;
import com.hcon.api.domain.Tuser;
import com.hcon.common.GridDataRet;
import io.swagger.annotations.ApiOperation;
import org.n3r.eql.EqlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kunlun on 2017/3/28.
 */
@RestController
@RequestMapping("hcon")
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ApiOperation(value = "用户集合", notes = "查询所有用户数据")
    public GridDataRet<List<Tuser>> getUser() {
        EqlPage page = new EqlPage(3, 2);
        GridDataRet ret = new GridDataRet();
        List<Tuser> userList = new ArrayList<>();
        userList = userService.queryByPage(page, "");
        ret.setList(userList);
        return ret;
    }
}
