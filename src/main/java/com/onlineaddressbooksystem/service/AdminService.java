package com.onlineaddressbooksystem.service;

import com.onlineaddressbooksystem.dto.AdminLoginDTO;
import com.onlineaddressbooksystem.vo.AdminVo;

public interface AdminService {
    AdminVo login(AdminLoginDTO adminLoginDTO);
}
