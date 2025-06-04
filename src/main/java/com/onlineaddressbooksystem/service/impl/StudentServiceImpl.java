package com.onlineaddressbooksystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.onlineaddressbooksystem.common.PageResult;
import com.onlineaddressbooksystem.dto.StudentBasicInfoDTO;
import com.onlineaddressbooksystem.dto.StudentLoginDTO;
import com.onlineaddressbooksystem.dto.StudentQueryDTO;
import com.onlineaddressbooksystem.dto.StudentRegisterDTO;
import com.onlineaddressbooksystem.entity.Student;
import com.onlineaddressbooksystem.exception.BusinessException;
import com.onlineaddressbooksystem.mapper.StudentMapper;
import com.onlineaddressbooksystem.service.StudentService;
import com.onlineaddressbooksystem.util.JwtUtil;
import com.onlineaddressbooksystem.vo.StudentInfoVo;
import com.onlineaddressbooksystem.vo.StudentVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final JwtUtil jwtUtil;
    private final StudentMapper studentMapper;

    @Override
    public StudentVO login(StudentLoginDTO studentLoginDTO) {
        StudentBasicInfoDTO studentBasicInfoDTO = studentMapper.partialQuery(studentLoginDTO.getId());
        if (studentBasicInfoDTO == null) {
            throw new BusinessException("账号不存在");
        }
        String password = studentLoginDTO.getPassword();
        if (password == null || password.isEmpty()) {
            throw new BusinessException("密码不能为空");
        }
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(studentBasicInfoDTO.getPassword())) {
            throw new BusinessException("密码错误");
        }
        if (!studentBasicInfoDTO.getIsApproved()) {
            throw new BusinessException("账号未通过审核");
        }
        if (!studentBasicInfoDTO.getIsActive()) {
            throw new BusinessException("账号已被锁定");
        }
        log.info("Login success");
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", studentBasicInfoDTO.getId());
        claims.put("name", studentBasicInfoDTO.getName());
        String token = jwtUtil.generateToken(claims);
        return new StudentVO(studentBasicInfoDTO.getId(), studentBasicInfoDTO.getName(), token);
    }

    @Override
    public void register(StudentRegisterDTO studentRegisterDTO) {
        StudentBasicInfoDTO studentBasicInfoDTO = studentMapper.partialQuery(studentRegisterDTO.getId());
        if (studentBasicInfoDTO != null) {
            throw new BusinessException("账号已存在");
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentRegisterDTO, student);
        student.setPassword(DigestUtils.md5DigestAsHex(student.getPassword().getBytes()));
        student.setIsActive(true);
        student.setIsApproved(false);
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }

    @Override
    public StudentInfoVo getInfo(Integer id) {
        return studentMapper.query(id);
    }

    @Override
    public PageResult<StudentInfoVo> page(StudentQueryDTO studentQueryDTO) {
        try (Page<?> ignore = PageHelper.startPage(studentQueryDTO.getPage(), studentQueryDTO.getSize())) {
            Page<StudentInfoVo> studentInfoVos = (Page<StudentInfoVo>) studentMapper.list(studentQueryDTO);
            return new PageResult<>(studentInfoVos.getTotal(), studentInfoVos);
        }
    }

    @Override
    public void update(Student student) {
        student.setPassword(DigestUtils.md5DigestAsHex(student.getPassword().getBytes()));
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }
}
