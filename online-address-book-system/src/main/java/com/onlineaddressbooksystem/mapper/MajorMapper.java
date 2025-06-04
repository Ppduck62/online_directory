package com.onlineaddressbooksystem.mapper;

import com.onlineaddressbooksystem.vo.MajorVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MajorMapper {
    List<MajorVo> list();
}
