package com.studio2h.javawebbbs.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * @author Galebrn
 */
public class JwtUtil {
    private static final String SECRET_KEY = "galebrn";
    private static final long EXPIRATION = 43200000L;

    public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .compact();
    }

    public static Claims parseJwt(String jwtToken){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJwt(jwtToken)
                .getBody();
    }
}
