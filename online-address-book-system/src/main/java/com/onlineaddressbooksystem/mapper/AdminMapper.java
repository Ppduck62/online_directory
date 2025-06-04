package com.onlineaddressbooksystem.mapper;

import com.onlineaddressbooksystem.dto.AdminBasicInfoDTO;
import com.onlineaddressbooksystem.vo.AdminVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    @Select("select id, name, password from admin where id = #{id}")
    AdminBasicInfoDTO queryById(Integer id);
}
