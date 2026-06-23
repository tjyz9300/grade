package com.score.mapper;

import com.score.entity.Course;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * 课程Mapper接口
 */
@Mapper
public interface CourseMapper {
    
    // 查询所有课程
    @Select("SELECT * FROM course")
    List<Course> findAll();
    
    // 根据课程号查询
    @Select("SELECT * FROM course WHERE course_id = #{courseId}")
    Course findById(String courseId);
    
    // 根据教师工号查询课程（教师可以上多门课程）
    @Select("SELECT * FROM course WHERE teacher_id = #{teacherId}")
    List<Course> findByTeacherId(String teacherId);
    
    // 新增课程
    @Insert("INSERT INTO course(course_id, course_name, teacher_id, credit) VALUES(#{courseId}, #{courseName}, #{teacherId}, #{credit})")
    int insert(Course course);
    
    // 更新课程
    @Update("UPDATE course SET course_name=#{courseName}, teacher_id=#{teacherId}, credit=#{credit} WHERE course_id=#{courseId}")
    int update(Course course);
    
    // 删除课程
    @Delete("DELETE FROM course WHERE course_id = #{courseId}")
    int delete(String courseId);
}
