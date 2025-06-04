package com.onlineaddressbooksystem.service.impl;

import com.onlineaddressbooksystem.mapper.MajorMapper;
import com.onlineaddressbooksystem.service.MajorService;
import com.onlineaddressbooksystem.vo.MajorVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MajorServiceImpl implements MajorService {
    private final MajorMapper majorMapper;

    @Override
    public List<MajorVo> list() {
        return majorMapper.list();
    }
}
