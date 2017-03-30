package com.hcon.api.service;

import com.hcon.api.domain.UserRegister;
import com.hcon.common.DataRet;
import com.hcon.utils.Md5;
import org.n3r.eql.EqlPage;
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
    public List<UserRegister> queryUserByCondition(EqlPage eqlPage, String key) {
        List<UserRegister> userRegisterList = new Dql().returnType(UserRegister.class)
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
        return new Dql().returnType(UserRegister.class).params(account).execute() != null ? true : false;
    }

    /**
     * 用户注册
     *
     * @param userRegister
     * @return
     */
    public DataRet<String> register(UserRegister userRegister) {
        DataRet dataRet = new DataRet();
        if (this.isRegister(userRegister.getAccount())) {
            dataRet.setErrorCode("ACCOUNT_EXIST");
            dataRet.setMessage("账号已存在,请重新输入！");
            return dataRet;
        }
        return dataRet;
    }

    /**
     * 用户登录
     *
     * @param userRegister
     * @return
     */
    public boolean login(UserRegister userRegister) {
        UserRegister user = new Dql().selectFirst("login")
                .returnType(UserRegister.class)
                .params(userRegister.getAccount())
                .execute();
        if (null != user) {
            logger.info("MD5加密值:{}",Md5.digest(userRegister.getLoginToken()));
            if (!Md5.digest(userRegister.getLoginToken()).equals(user.getLoginToken())) {
                return false;
            }
            return true;
        }
        return false;

    }
}
