package com.hcon.consts;

import com.hcon.utils.Aes;
import org.n3r.diamond.client.Miner;
import org.n3r.diamond.client.Minerable;

import java.security.Key;

/**
 * 静态常量
 * Created by kunlun on 2017/3/29.
 */
public class AuthConstants {


    private static Minerable minerable = new Miner().getMiner("hcon.base", "cookie.domain");

    public static class SYS {
        //cookie有效时间
        public static int EXPIRE_SECONDS = minerable.getInt("sys.cookieExpireSecs", 7200);
        //加密salt
        public static Key COOKIE_DECRYPT_KEY = Aes.getKey(
                minerable.getString("sys.cookieDecryptKey", "CKJQHREHIUYFGQUWIBNRIT"));

        //CookieName
        public static String COOKIE_NAME = minerable.getString("sys.cookieName", "hcon_auth_sys");

        //token 加密salt
        public static Key TOKEN_DECRYPT_KEY = Aes.getKey(
                minerable.getString("sys.tokenDecryptKey", "zA8bDpwzL3DHdSGavu8HQs"));

        //token  名称
        public static String TOKEN_NAME = minerable.getString("sys.tokenName", "auth_sys_token");

        //token 有效时间
        public static int TOKEN_EXPIRE_SECONDS = 7200;

    }
}
