package com.hcon.api.controller;

import com.hcon.core.common.DataRet;
import com.hcon.core.common.GridDataRet;
import io.swagger.annotations.*;
import org.n3r.eql.EqlPage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kunlun on 2017/3/30.
 */
@RestController
@RequestMapping("role")
@Api(value = "平台角色接口")
public class PubUserRoleController {


    @ApiOperation(value = "查询角色列表")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "当前页", name = "currentPages", required = true, dataType = "int"),
            @ApiImplicitParam(value = "每页条数", name = "pageRows", required = true, dataType = "int"),
            @ApiImplicitParam(value = "搜索关键字", name = "key", dataType = "String")})
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public GridDataRet<PubUserRole> list(EqlPage eqlPage, String key) {
        return null;
    }


    @ApiOperation(value = "创建角色")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataRet<String> create(@RequestBody PubUserRole userRole) {
        return null;
    }


    @ApiOperation(value = "删除角色")
    @ApiImplicitParam(value = "角色id", name = "id", dataType = "String", required = true)
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public DataRet<String> del(String id) {
        return null;
    }

    @ApiOperation(value = "角色详情")
    @ApiImplicitParam(value = "角色id", name = "id", dataType = "String", required = true)
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public DataRet<String> detail(String id) {
        return null;
    }
}
