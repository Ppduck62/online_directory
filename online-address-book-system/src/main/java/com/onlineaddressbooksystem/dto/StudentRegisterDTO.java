package com.onlineaddressbooksystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRegisterDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String password;
    private Integer majorId;
    private Integer classId;
    private Integer enrollmentYear;
    private Integer graduationYear;
    private String employment;
    private String city;
    private String phone;
    private String email;
}
