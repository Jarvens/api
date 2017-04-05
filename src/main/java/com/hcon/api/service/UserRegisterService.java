package com.hcon.api.service;

import com.hcon.api.domain.SysUser;
import com.hcon.core.common.DataRet;
import com.hcon.utils.Md5;
import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;
import org.n3r.eql.diamond.Dql;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kunlun on 2017/3/28.
 */
@Service
public class UserRegisterService {

    private static Logger logger = LoggerFactory.getLogger(UserRegisterService.class);

    /**
     * 搜索查询用户信息并分页
     *
     * @param eqlPage
     * @param key
     * @return
     */
    public List<SysUser> queryUserByCondition(EqlPage eqlPage, String key) {
        List<SysUser> userRegisterList = new Dql().returnType(SysUser.class)
                .params(key)
                .limit(eqlPage)
                .execute();
        return userRegisterList;
    }

    /**
     * 检查用户是否已经注册过
     *
     * @param account
     * @return
     */
    public Boolean isRegister(String account) {
        return new Dql().returnType(SysUser.class).params(account).execute() != null ? true : false;
    }

    /**
     * 用户注册
     *
     * @param sysUser
     * @return
     */
    public DataRet<String> register(SysUser sysUser) {
        DataRet dataRet = new DataRet();
        if (this.isRegister(sysUser.getAccount())) {
            return this.result("account_exist", "账号已存在,请重新输入");
        }
        if (this.queryUserByUserName(sysUser.getName())) {
            return this.result("userName_exist", "用户名已存在,请重新输入");
        }
        String password = Md5.digest("888888");
        sysUser.setPassword(password);
        return dataRet;
    }

    /**
     * 用户登录
     *
     * @param sysUser
     * @return
     */
    public boolean login(SysUser sysUser) {
        EqlTran eqlTran = new Dql().newTran();
        SysUser user = new Dql().selectFirst("login")
                .returnType(SysUser.class)
                .params(sysUser.getAccount())
                .execute();
        if (null != user) {
            logger.info("MD5加密值:{}", Md5.digest(sysUser.getPassword()));
            if (!Md5.digest(sysUser.getPassword()).equals(user.getPassword())) {
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * 检查用户名是否存在
     *
     * @param userName
     * @return
     */
    public boolean queryUserByUserName(String userName) {
        return new Dql().selectFirst("queryUserByUserName")
                .returnType(SysUser.class)
                .params(userName)
                .execute() == null ? true : false;
    }

    /**
     * 公共方法
     *
     * @param errorCode
     * @param message
     * @return
     */
    private DataRet<String> result(String errorCode, String message) {
        DataRet<String> ret = new DataRet<>();
        ret.setErrorCode(errorCode);
        ret.setMessage(message);
        return ret;
    }
}
