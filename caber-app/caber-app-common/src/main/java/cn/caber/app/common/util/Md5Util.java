package cn.caber.app.common.util;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

public class Md5Util {
    public static String encrypt(String str) {
        String s = DigestUtils.md5DigestAsHex(str.getBytes(StandardCharsets.UTF_8));
        return s;
    }


}
