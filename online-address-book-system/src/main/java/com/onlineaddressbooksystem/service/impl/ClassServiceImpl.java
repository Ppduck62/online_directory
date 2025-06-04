package com.onlineaddressbooksystem.service.impl;

import com.onlineaddressbooksystem.mapper.ClassMapper;
import com.onlineaddressbooksystem.service.ClassService;
import com.onlineaddressbooksystem.vo.ClassVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {
    private final ClassMapper classMapper;

    @Override
    public List<ClassVo> get(Integer majorId) {
        return classMapper.query(majorId);
    }
}
