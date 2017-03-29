package com.hcon.api.service;

import com.hcon.api.domain.UserRegister;
import com.hcon.common.DataRet;
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
    private List<UserRegister> queryUserByCondition(EqlPage eqlPage, String key) {
        return new Dql().returnType(UserRegister.class).params(key).limit(eqlPage).execute();
    }

    /**
     * 检查用户是否已经注册过
     *
     * @param account
     * @return
     */
    private Boolean isRegister(String account) {
        return new Dql().returnType(UserRegister.class).params(account).execute() == null ? true : false;
    }

    private DataRet<String> register(UserRegister userRegister) {
        DataRet dataRet = new DataRet();
        if (this.isRegister(userRegister.getAccount())) {
            dataRet.setErrorCode("ACCOUNT_EXIST");
            dataRet.setMessage("账号已存在,请重新输入！");
            return dataRet;
        }
        return dataRet;
    }
}
