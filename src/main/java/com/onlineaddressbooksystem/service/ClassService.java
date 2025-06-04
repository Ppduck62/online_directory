package com.onlineaddressbooksystem.service;

import com.onlineaddressbooksystem.vo.ClassVo;

import java.util.List;

public interface ClassService {
    List<ClassVo> get(Integer majorId);
}
