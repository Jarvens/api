package com.hcon.api.service;

import com.hcon.api.domain.Tuser;
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
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    public List<Tuser> queryByPage(EqlPage page, String key) {
        List<Tuser> list = new Dql().returnType(Tuser.class).limit(page).execute();
        return list;
    }
}
