package com.onlineaddressbooksystem.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

@Slf4j
public class DigestUtilsTest {
    @Test
    public void test() {
        String password = "123456";
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        log.info(password);
    }
}
