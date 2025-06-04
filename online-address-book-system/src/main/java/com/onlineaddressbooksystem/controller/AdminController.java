package com.onlineaddressbooksystem.controller;

import com.onlineaddressbooksystem.common.Result;
import com.onlineaddressbooksystem.dto.AdminLoginDTO;
import com.onlineaddressbooksystem.service.AdminService;
import com.onlineaddressbooksystem.vo.AdminVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @RequestMapping("/login")
    public Result<AdminVo> login(@RequestBody AdminLoginDTO adminLoginDTO) {
        log.info("Admin login: {}", adminLoginDTO);
        AdminVo adminVo = adminService.login(adminLoginDTO);
        return Result.success(adminVo);
    }
}
