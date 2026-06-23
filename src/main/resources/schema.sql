-- 创建数据库
CREATE DATABASE IF NOT EXISTS score_db DEFAULT CHARACTER SET utf8mb4;
USE score_db;

-- 教师表（工号、性别）
CREATE TABLE IF NOT EXISTS teacher (
    teacher_id VARCHAR(20) PRIMARY KEY COMMENT '工号',
    gender VARCHAR(10) NOT NULL COMMENT '性别'
) COMMENT '教师表';

-- 课程表（课程号、课程名、任课教师工号、学分）
CREATE TABLE IF NOT EXISTS course (
    course_id VARCHAR(20) PRIMARY KEY COMMENT '课程号',
    course_name VARCHAR(50) NOT NULL COMMENT '课程名',
    teacher_id VARCHAR(20) NOT NULL COMMENT '任课教师工号',
    credit INT NOT NULL COMMENT '学分',
    FOREIGN KEY (teacher_id) REFERENCES teacher(teacher_id)
) COMMENT '课程表';

-- 学生表（学号、姓名、出生年月日、性别）
CREATE TABLE IF NOT EXISTS student (
    student_id VARCHAR(20) PRIMARY KEY COMMENT '学号',
    name VARCHAR(50) NOT NULL COMMENT '姓名',
    birthday DATE NOT NULL COMMENT '出生年月日',
    gender VARCHAR(10) NOT NULL COMMENT '性别'
) COMMENT '学生表';

-- 成绩表（学生选课+成绩，成绩由教师给出）
CREATE TABLE IF NOT EXISTS score (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id VARCHAR(20) NOT NULL COMMENT '学号',
    course_id VARCHAR(20) NOT NULL COMMENT '课程号',
    score DECIMAL(5,2) COMMENT '成绩',
    FOREIGN KEY (student_id) REFERENCES student(student_id),
    FOREIGN KEY (course_id) REFERENCES course(course_id),
    UNIQUE KEY uk_student_course (student_id, course_id)
) COMMENT '成绩表';



