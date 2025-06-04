package com.onlineaddressbooksystem.controller;

import com.onlineaddressbooksystem.common.Result;
import com.onlineaddressbooksystem.service.ClassService;
import com.onlineaddressbooksystem.vo.ClassVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/class")
@RequiredArgsConstructor
public class ClassController {
    private final ClassService classService;

    @GetMapping("/{majorId}")
    public Result<List<ClassVo>> get(@PathVariable Integer majorId) {
        List<ClassVo> classes = classService.get(majorId);
        return Result.success(classes);
    }
}
