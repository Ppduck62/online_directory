package com.onlineaddressbooksystem.service.impl;

import com.onlineaddressbooksystem.dto.AdminBasicInfoDTO;
import com.onlineaddressbooksystem.dto.AdminLoginDTO;
import com.onlineaddressbooksystem.exception.BusinessException;
import com.onlineaddressbooksystem.mapper.AdminMapper;
import com.onlineaddressbooksystem.service.AdminService;
import com.onlineaddressbooksystem.util.JwtUtil;
import com.onlineaddressbooksystem.vo.AdminVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final JwtUtil jwtUtil;
    private final AdminMapper adminMapper;

    @Override
    public AdminVo login(AdminLoginDTO adminLoginDTO) {
        AdminBasicInfoDTO adminBasicInfoDTO = adminMapper.queryById(adminLoginDTO.getId());
        if (adminBasicInfoDTO == null) {
            throw new BusinessException("账号不存在");
        }
        String password = adminLoginDTO.getPassword();
        if (password == null || password.isEmpty()) {
            throw new BusinessException("密码不能为空");
        }
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(adminBasicInfoDTO.getPassword())) {
            throw new BusinessException("密码错误");
        }
        log.info("Admin login success");
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", adminBasicInfoDTO.getId());
        claims.put("name", adminBasicInfoDTO.getName());
        String token = jwtUtil.generateToken(claims);
        return new AdminVo(adminBasicInfoDTO.getId(), adminBasicInfoDTO.getName(), token);
    }
}
