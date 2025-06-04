package com.onlineaddressbooksystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentQueryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer page;
    private Integer size;
    private String name;
    private Integer enrollmentYear;
    private Integer graduationYear;
}
