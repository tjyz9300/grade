package com.score.service;

import com.score.entity.Student;
import com.score.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 学生Service层
 */
@Service
public class StudentService {
    
    @Autowired
    private StudentMapper studentMapper;
    
    public List<Student> findAll() {
        return studentMapper.findAll();
    }
    
    public Student findById(String studentId) {
        return studentMapper.findById(studentId);
    }
    
    public int save(Student student) {
        return studentMapper.insert(student);
    }
    
    public int update(Student student) {
        return studentMapper.update(student);
    }
    
    public int delete(String studentId) {
        return studentMapper.delete(studentId);
    }
}
