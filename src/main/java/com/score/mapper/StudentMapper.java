package com.score.mapper;

import com.score.entity.Student;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * 学生Mapper接口
 */
@Mapper
public interface StudentMapper {
    
    // 查询所有学生
    @Select("SELECT * FROM student")
    List<Student> findAll();
    
    // 根据学号查询学生
    @Select("SELECT * FROM student WHERE student_id = #{studentId}")
    Student findById(String studentId);
    
    // 新增学生
    @Insert("INSERT INTO student(student_id, name, birthday, gender) VALUES(#{studentId}, #{name}, #{birthday}, #{gender})")
    int insert(Student student);
    
    // 更新学生
    @Update("UPDATE student SET name=#{name}, birthday=#{birthday}, gender=#{gender} WHERE student_id=#{studentId}")
    int update(Student student);
    
    // 删除学生
    @Delete("DELETE FROM student WHERE student_id = #{studentId}")
    int delete(String studentId);
}
