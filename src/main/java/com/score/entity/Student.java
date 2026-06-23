package com.score.entity;

import lombok.Data;
import java.util.Date;
import java.util.Vector;

/**
 * 学生实体类
 * 属性：学号、姓名、出生年月日、性别
 * 功能：学生可以选择多门课程，学生可以查询自己的成绩
 */
@Data
public class Student {
    private String studentId;    // 学号
    private String name;         // 姓名
    private Date birthday;       // 出生年月日
    private String gender;       // 性别
    
    // 使用Vector存储学生的成绩列表（复习vector的使用）
    private Vector<Score> scores = new Vector<>();
}
