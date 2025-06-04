package com.onlineaddressbooksystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String password;
    private LocalDateTime lastLoginTime;
    private Integer loginCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
