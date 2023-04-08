package cn.caber.app.common.util;

import cn.caber.app.common.exception.ServiceErrorCode;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.util.CollectionUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JwtUtil {


    private static final String secretKey = "caber";

    public static String createJwt(Map<String, Object> data, Long duration) {
        JWTCreator.Builder builder = JWT.create().withJWTId(UUID.randomUUID().toString()).withIssuedAt(new Date());

        if (!CollectionUtils.isEmpty(data)) {
            builder.withClaim("data", data);
        }
        if (duration > 0) {
            builder.withExpiresAt(new Date(System.currentTimeMillis() + duration));
        }
        return builder.sign(Algorithm.HMAC256(secretKey.getBytes(StandardCharsets.UTF_8)));
    }

    public static Map<String, Object> parseJwt(String token) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(secretKey.getBytes(StandardCharsets.UTF_8))).build().verify(token);
        return verify.getClaim("data").asMap();
    }


    public static void main(String[] args) {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("name", "caber");
        stringObjectHashMap.put("account", "22222");
        stringObjectHashMap.put("password", "111111");
        String jwt = createJwt(stringObjectHashMap, 30L * 1000L);
        System.out.println(jwt);
        System.out.println(parseJwt(jwt));
    }
}
