package com.onlineaddressbooksystem.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "oabs.jwt")
public class JwtProperty {
    private String secretKey;
    private long expirationTime;
}
