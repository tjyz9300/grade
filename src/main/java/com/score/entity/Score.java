package com.score.entity;

import lombok.Data;

/**
 * 成绩实体类
 * 学生可以选择多门课程，但成绩必须教师给出
 */
@Data
public class Score {
    private Integer id;
    private String studentId;    // 学号
    private String courseId;     // 课程号
    private Double score;        // 成绩
    
    // 关联对象
    private Student student;
    private Course course;
}
