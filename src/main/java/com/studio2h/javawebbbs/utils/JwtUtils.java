package com.studio2h.javawebbbs.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Map;

/**
 * @author Galebrn
 */
public class JwtUtils {
    private static final String SECRET_KEY = generateRandomKey();
    private static final long EXPIRATION = 43200000L;

    public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .compact();
    }

    public static Claims parseJwt(String jwtToken) {
        JwtParser jwtParser = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build();

        return jwtParser.parseClaimsJws(jwtToken)
                .getBody();
    }

    private static String generateRandomKey() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder keyStringBuilder = new StringBuilder();

        while (keyStringBuilder.length() < 64) {
            int randomInt = secureRandom.nextInt(52);
            char randomChar;
            if (randomInt < 26) {
                randomChar = (char) (randomInt + 'a');
            } else {
                randomChar = (char) (randomInt - 26 + 'A');
            }
            keyStringBuilder.append(randomChar);
        }

        return keyStringBuilder.toString();
    }
}
