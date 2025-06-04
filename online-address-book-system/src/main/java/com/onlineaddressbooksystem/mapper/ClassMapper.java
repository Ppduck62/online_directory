package com.onlineaddressbooksystem.mapper;

import com.onlineaddressbooksystem.vo.ClassVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {
    List<ClassVo> query(Integer majorId);
}
