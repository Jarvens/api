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

    public static final String HCON_AUTH_FAIL = "HCON.FAIL";

    private static Minerable minerable = new Miner().getMiner("hcon.base", "cookie.domain");

    public static class SYS {
        //cookie有效时间
        public static int EXPIRE_SECONDS = minerable.getInt("sys.cookieExpireSecs", 7200);
        //加密salt
        public static Key COOKIE_DECRYPT_KEY = Aes.getKey(
                minerable.getString("sys.cookieDecryptKey", "CKJQHREHIUYFG QUWIBNRIT"));

        //CookieName
        public static String COOKIE_NAME = minerable.getString("sys.cookieName", "hcon_auth_sys");
    }
}
