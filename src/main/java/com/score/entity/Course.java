package com.score.entity;

import lombok.Data;

/**
 * 课程实体类
 * 属性：课程号、课程名、任课教师工号、学分
 */
@Data
public class Course {
    private String courseId;     // 课程号
    private String courseName;   // 课程名
    private String teacherId;    // 任课教师工号
    private Integer credit;      // 学分
    
    // 关联的教师对象
    private Teacher teacher;
}
