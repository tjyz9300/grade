package com.score.mapper;

import com.score.entity.Teacher;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * 教师Mapper接口
 */
@Mapper
public interface TeacherMapper {
    
    // 查询所有教师
    @Select("SELECT * FROM teacher")
    List<Teacher> findAll();
    
    // 根据工号查询教师
    @Select("SELECT * FROM teacher WHERE teacher_id = #{teacherId}")
    Teacher findById(String teacherId);
    
    // 新增教师
    @Insert("INSERT INTO teacher(teacher_id, gender) VALUES(#{teacherId}, #{gender})")
    int insert(Teacher teacher);
    
    // 更新教师
    @Update("UPDATE teacher SET gender=#{gender} WHERE teacher_id=#{teacherId}")
    int update(Teacher teacher);
    
    // 删除教师
    @Delete("DELETE FROM teacher WHERE teacher_id = #{teacherId}")
    int delete(String teacherId);
}
