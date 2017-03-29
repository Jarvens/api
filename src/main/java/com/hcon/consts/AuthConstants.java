package com.hcon.consts;

import org.n3r.diamond.client.Miner;
import org.n3r.diamond.client.Minerable;

/**
 * 静态常量
 * Created by kunlun on 2017/3/29.
 */
public class AuthConstants {

    private static Minerable minerable = new Miner().getMiner("hcon.base", "cookie.domain");

    public static class SYS {
        //cookie有效时间
        public static int EXPIRE_SECONDS = minerable.getInt("sys.cookieExpireSecs", 7200);
    }
}
