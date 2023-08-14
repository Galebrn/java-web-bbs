package com.studio2h.javawebbbs.util;

import com.studio2h.javawebbbs.pojo.request.UserLoginRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Galebrn
 */
public class JwtUtil {
    private static final String secretKey = "galebrn";
    private static final long expiration = 43200000L;

    public static String generateJwt(Map<String, Object> claims) {
        String jwtToken = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .compact();
        return jwtToken;
    }

    public static Claims parseJwt(String jwtToken){
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJwt(jwtToken)
                .getBody();
        return claims;
    }
}
