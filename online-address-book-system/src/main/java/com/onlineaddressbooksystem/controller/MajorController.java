package com.onlineaddressbooksystem.controller;

import com.onlineaddressbooksystem.common.Result;
import com.onlineaddressbooksystem.service.MajorService;
import com.onlineaddressbooksystem.vo.MajorVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/major")
@RequiredArgsConstructor
public class MajorController {
    private final MajorService majorService;

    @GetMapping("/list")
    public Result<List<MajorVo>> list() {
        List<MajorVo> majorVoList = majorService.list();
        return Result.success(majorVoList);
    }
}
