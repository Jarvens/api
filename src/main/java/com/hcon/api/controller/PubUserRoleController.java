package com.hcon.api.controller;

import com.hcon.api.domain.PubUserRole;
import com.hcon.common.DataRet;
import com.hcon.common.GridDataRet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

    /**
     * 查询角色列表并分页
     * @param eqlPage
     * @param key
     * @return
     */
    @ApiOperation(value = "查询角色列表", notes = "条件查询角色列表并分页")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "当前页", name = "currentPages", required = true, dataType = "int"),
            @ApiImplicitParam(value = "每页条数", name = "pageRows", required = true, dataType = "int"),
            @ApiImplicitParam(value = "搜索关键字", name = "key", dataType = "String")})
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public GridDataRet<PubUserRole> list(EqlPage eqlPage, String key) {
        return null;
    }

    /**
     * 创建角色
     * @param userRole
     * @return
     */
    @ApiOperation(value = "创建角色", notes = "创建角色")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DataRet<String> create(@RequestBody PubUserRole userRole) {
        return null;
    }

}
