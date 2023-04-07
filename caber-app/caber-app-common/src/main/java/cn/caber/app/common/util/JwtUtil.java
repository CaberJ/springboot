package cn.caber.app.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Component
public class JwtUtil {

    private String secretKey;

    public String createJwt(Map<String, Object> data, Long duration) {
        JwtBuilder builder = Jwts.builder();
        builder.setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date()) // 发行时间
                .signWith(SignatureAlgorithm.HS256, secretKey);
        if (!CollectionUtils.isEmpty(data)) {
            builder.setClaims(data);
        }
        if (duration > 0) {
            builder.setExpiration(new Date(System.currentTimeMillis() + duration));
        }
        return builder.compact();
    }

    public Claims parseJwt(String jwtString) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtString).getBody();
    }
}
