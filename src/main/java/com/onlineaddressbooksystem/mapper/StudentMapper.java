package com.onlineaddressbooksystem.mapper;

import com.onlineaddressbooksystem.dto.StudentBasicInfoDTO;
import com.onlineaddressbooksystem.dto.StudentQueryDTO;
import com.onlineaddressbooksystem.entity.Student;
import com.onlineaddressbooksystem.vo.StudentInfoVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select id, name, password, is_approved, is_active from student where id = #{id}")
    StudentBasicInfoDTO partialQuery(Integer id);

    @Insert("insert into student(id, name, password, major_id, class_id, enrollment_year, graduation_year, employment, " +
            "city, phone, email, is_approved, is_active, create_time, update_time) " +
            "values (#{id}, #{name}, #{password}, #{majorId}, #{classId}, #{enrollmentYear}, #{graduationYear}, #{employment}, " +
            "#{city}, #{phone}, #{email}, #{isApproved}, #{isActive}, #{createTime}, #{updateTime})")
    void insert(Student student);

    @Select("select id, name, password, major_id, class_id, enrollment_year, graduation_year, employment, " +
            "city, phone, email, is_approved, is_active, create_time, update_time from student where id = #{id}")
    StudentInfoVo query(Integer id);

    List<StudentInfoVo> list(StudentQueryDTO studentQueryDTO);

    @Update("update student set name = #{name}, password = #{password}, major_id = #{majorId}, class_id = #{classId}, " +
            "enrollment_year = #{enrollmentYear}, graduation_year = #{graduationYear}, employment = #{employment}, " +
            "city = #{city}, phone = #{phone}, email = #{email}, " +
            "update_time = #{updateTime} where id = #{id}")
    void update(Student student);
}
