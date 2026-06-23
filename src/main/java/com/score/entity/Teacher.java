package com.score.entity;

import lombok.Data;
import java.util.Vector;

/**
 * 教师实体类
 * 属性：工号、性别
 * 功能：教师可以上多门课程，教师可以给多个学生上课，教师可查询自己任课课程的成绩
 */
@Data
public class Teacher {
    private String teacherId;    // 工号
    private String gender;       // 性别
    
    // 使用Vector存储教师的课程列表（教师可以上多门课程）
    private Vector<Course> courses = new Vector<>();
}
