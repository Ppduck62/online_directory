package com.onlineaddressbooksystem.util;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
class JwtUtilTest {
    @Autowired
    private JwtUtil jwtUtil;

    @Test
    public void test() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 20220001);
        claims.put("password", "1234");
        String token = jwtUtil.generateToken(claims);
        log.info("Generated token: {}", token);
        Claims parsedClaims = jwtUtil.parseToken(token);
        assertEquals(20220001, parsedClaims.get("id"));
    }
}
