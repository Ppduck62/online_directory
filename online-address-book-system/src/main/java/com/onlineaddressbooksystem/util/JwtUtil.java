package com.onlineaddressbooksystem.util;

import com.onlineaddressbooksystem.common.JwtProperty;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtUtil {
    private final JwtProperty jwtProperty;

    public String generateToken(Map<String, Object> claims) {
        log.info("Generating token with claims: {}", claims);
        SecretKey secretKey = Keys.hmacShaKeyFor(jwtProperty.getSecretKey().getBytes(StandardCharsets.UTF_8));
        Date expirationTime = new Date(System.currentTimeMillis() + jwtProperty.getExpirationTime());
        return Jwts.builder()
                .signWith(secretKey)
                .addClaims(claims)
                .setExpiration(expirationTime)
                .compact();
    }

    public Claims parseToken(String token) {
        log.info("Parsing token: {}", token);
        SecretKey secretKey = Keys.hmacShaKeyFor(jwtProperty.getSecretKey().getBytes(StandardCharsets.UTF_8));
        return Jwts.parserBuilder().
                setSigningKey(secretKey).
                build().
                parseClaimsJws(token).
                getBody();
    }
}
