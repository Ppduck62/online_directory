package com.onlineaddressbooksystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentLoginDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String password;
}
