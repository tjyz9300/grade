package com.score.mapper;

import com.score.entity.Score;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

/**
 * 成绩Mapper接口
 */
@Mapper
public interface ScoreMapper {
    
    // 查询所有成绩
    @Select("SELECT s.*, st.name as student_name, c.course_name " +
            "FROM score s " +
            "LEFT JOIN student st ON s.student_id = st.student_id " +
            "LEFT JOIN course c ON s.course_id = c.course_id")
    @Results({
        @Result(property = "student.name", column = "student_name"),
        @Result(property = "course.courseName", column = "course_name")
    })
    List<Score> findAll();
    
    // 学生查询自己的成绩
    @Select("SELECT s.*, c.course_name, c.credit " +
            "FROM score s " +
            "LEFT JOIN course c ON s.course_id = c.course_id " +
            "WHERE s.student_id = #{studentId}")
    @Results({
        @Result(property = "course.courseName", column = "course_name"),
        @Result(property = "course.credit", column = "credit")
    })
    List<Score> findByStudentId(String studentId);
    
    // 教师查询自己任课课程的成绩
    @Select("SELECT s.*, st.name as student_name, c.course_name " +
            "FROM score s " +
            "LEFT JOIN student st ON s.student_id = st.student_id " +
            "LEFT JOIN course c ON s.course_id = c.course_id " +
            "WHERE c.teacher_id = #{teacherId}")
    @Results({
        @Result(property = "student.name", column = "student_name"),
        @Result(property = "course.courseName", column = "course_name")
    })
    List<Score> findByTeacherId(String teacherId);
    
    // 教师给学生打分（成绩必须教师给出）
    @Insert("INSERT INTO score(student_id, course_id, score) VALUES(#{studentId}, #{courseId}, #{score}) " +
            "ON DUPLICATE KEY UPDATE score = #{score}")
    int giveScore(Score score);
    
    // 统计每个学生的平均成绩
    @Select("SELECT st.student_id, st.name, AVG(s.score) as avg_score " +
            "FROM student st " +
            "LEFT JOIN score s ON st.student_id = s.student_id " +
            "GROUP BY st.student_id, st.name")
    List<Map<String, Object>> getStudentAvgScores();
    
    // 统计每门课程的平均成绩
    @Select("SELECT c.course_id, c.course_name, AVG(s.score) as avg_score " +
            "FROM course c " +
            "LEFT JOIN score s ON c.course_id = s.course_id " +
            "GROUP BY c.course_id, c.course_name")
    List<Map<String, Object>> getCourseAvgScores();
    
    // 删除成绩
    @Delete("DELETE FROM score WHERE id = #{id}")
    int delete(Integer id);
}
