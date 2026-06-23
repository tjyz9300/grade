package com.score.service;

import com.score.entity.Teacher;
import com.score.entity.Course;
import com.score.mapper.TeacherMapper;
import com.score.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Vector;

/**
 * 教师Service层
 */
@Service
public class TeacherService {
    
    @Autowired
    private TeacherMapper teacherMapper;
    
    @Autowired
    private CourseMapper courseMapper;
    
    public List<Teacher> findAll() {
        List<Teacher> teachers = teacherMapper.findAll();
        // 为每个教师加载其课程列表（教师可以上多门课程）
        for (Teacher teacher : teachers) {
            List<Course> courseList = courseMapper.findByTeacherId(teacher.getTeacherId());
            Vector<Course> courses = new Vector<>(courseList);
            teacher.setCourses(courses);
        }
        return teachers;
    }
    
    public Teacher findById(String teacherId) {
        Teacher teacher = teacherMapper.findById(teacherId);
        if (teacher != null) {
            List<Course> courseList = courseMapper.findByTeacherId(teacherId);
            teacher.setCourses(new Vector<>(courseList));
        }
        return teacher;
    }
    
    public int save(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }
    
    public int update(Teacher teacher) {
        return teacherMapper.update(teacher);
    }
    
    public int delete(String teacherId) {
        return teacherMapper.delete(teacherId);
    }
}
