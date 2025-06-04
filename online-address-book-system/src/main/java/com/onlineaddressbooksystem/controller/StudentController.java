package com.onlineaddressbooksystem.controller;

import com.onlineaddressbooksystem.common.PageResult;
import com.onlineaddressbooksystem.common.Result;
import com.onlineaddressbooksystem.dto.StudentLoginDTO;
import com.onlineaddressbooksystem.dto.StudentQueryDTO;
import com.onlineaddressbooksystem.dto.StudentRegisterDTO;
import com.onlineaddressbooksystem.entity.Student;
import com.onlineaddressbooksystem.service.StudentService;
import com.onlineaddressbooksystem.vo.StudentInfoVo;
import com.onlineaddressbooksystem.vo.StudentVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/login")
    public Result<StudentVO> login(@RequestBody StudentLoginDTO studentLoginDTO) {
        log.info("Student login: {}", studentLoginDTO);
        StudentVO studentVO = studentService.login(studentLoginDTO);
        log.info("Student login success: {}", studentVO);
        return Result.success(studentVO);
    }

    @PostMapping("/register")
    public Result<Void> register(@RequestBody StudentRegisterDTO studentRegisterDTO) {
        log.info("Student register: id = {}", studentRegisterDTO.getId());
        studentService.register(studentRegisterDTO);
        return Result.success("注册成功！等待管理员审核通过");
    }

    @GetMapping("{id}")
    public Result<StudentInfoVo> getInfo(@PathVariable Integer id) {
        log.info("Student getInfo: id = {}", id);
        StudentInfoVo studentInfoVo = studentService.getInfo(id);
        return Result.success(studentInfoVo);
    }

    @GetMapping("/page")
    public Result<PageResult<StudentInfoVo>> page(@RequestBody StudentQueryDTO studentQueryDTO) {
        log.info("Student page: {}", studentQueryDTO);
        PageResult<StudentInfoVo> pageResult = studentService.page(studentQueryDTO);
        return Result.success(pageResult);
    }

    @PostMapping("/update")
    public Result<Void> update(@RequestBody Student student) {
        log.info("Student update: {}", student);
        studentService.update(student);
        return Result.success();
    }
}
