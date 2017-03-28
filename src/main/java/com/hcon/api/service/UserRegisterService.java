package com.hcon.api.service;

import com.hcon.api.domain.UserRegiter;
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
    private List<UserRegiter> queryUserByCondition(EqlPage eqlPage, String key) {
        return new Dql().returnType(UserRegiter.class).params(key).limit(eqlPage).execute();
    }
}
