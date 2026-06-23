package com.score.service;

import com.score.entity.Course;
import com.score.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 课程Service层
 */
@Service
public class CourseService {
    
    @Autowired
    private CourseMapper courseMapper;
    
    public List<Course> findAll() {
        return courseMapper.findAll();
    }
    
    public Course findById(String courseId) {
        return courseMapper.findById(courseId);
    }
    
    // 根据教师工号查询课程（教师可以上多门课程）
    public List<Course> findByTeacherId(String teacherId) {
        return courseMapper.findByTeacherId(teacherId);
    }
    
    public int save(Course course) {
        return courseMapper.insert(course);
    }
    
    public int update(Course course) {
        return courseMapper.update(course);
    }
    
    public int delete(String courseId) {
        return courseMapper.delete(courseId);
    }
}
