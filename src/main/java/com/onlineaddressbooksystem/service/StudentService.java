package com.onlineaddressbooksystem.service;

import com.onlineaddressbooksystem.common.PageResult;
import com.onlineaddressbooksystem.dto.StudentLoginDTO;
import com.onlineaddressbooksystem.dto.StudentQueryDTO;
import com.onlineaddressbooksystem.dto.StudentRegisterDTO;
import com.onlineaddressbooksystem.entity.Student;
import com.onlineaddressbooksystem.vo.StudentInfoVo;
import com.onlineaddressbooksystem.vo.StudentVO;

public interface StudentService {
    StudentVO login(StudentLoginDTO studentLoginDTO);

    void register(StudentRegisterDTO studentRegisterDTO);

    StudentInfoVo getInfo(Integer id);

    PageResult<StudentInfoVo> page(StudentQueryDTO studentQueryDTO);

    void update(Student student);
}
