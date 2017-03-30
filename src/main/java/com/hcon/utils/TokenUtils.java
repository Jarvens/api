package com.hcon.utils;

import com.alibaba.fastjson.JSON;
import com.hcon.api.domain.UserRegister;
import com.hcon.consts.AuthConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * Token工具类
 * Created by kunlun on 2017/3/30.
 */
public class TokenUtils {

    private static final Logger logger = LoggerFactory.getLogger(TokenUtils.class);

    /**
     * 生成Token
     *
     * @param userRegister
     * @return
     */
    public static String createToken(UserRegister userRegister) {
        if (!StringUtils.hasLength(userRegister.getAccount())) {
            logger.info("无法读取账户信息...");
            return null;
        }
        String tokenVal = Aes.encrypt(JSON.toJSONString(userRegister), AuthConstants.SYS.TOKEN_DECRYPT_KEY);
        logger.info("tokenName:{},tokenValue:{}",tokenVal);
        return tokenVal;
    }
}
