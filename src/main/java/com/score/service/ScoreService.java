package com.score.service;

import com.score.entity.Score;
import com.score.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * 成绩Service层
 */
@Service
public class ScoreService {
    
    @Autowired
    private ScoreMapper scoreMapper;
    
    public List<Score> findAll() {
        return scoreMapper.findAll();
    }
    
    // 学生可以查询自己的成绩
    public List<Score> findByStudentId(String studentId) {
        return scoreMapper.findByStudentId(studentId);
    }
    
    // 教师可查询自己任课课程的成绩
    public List<Score> findByTeacherId(String teacherId) {
        return scoreMapper.findByTeacherId(teacherId);
    }
    
    // 教师给学生打分（成绩必须教师给出）
    public int giveScore(Score score) {
        return scoreMapper.giveScore(score);
    }
    
    // 统计每个学生的平均成绩
    public List<Map<String, Object>> getStudentAvgScores() {
        return scoreMapper.getStudentAvgScores();
    }
    
    // 统计每门课程的平均成绩
    public List<Map<String, Object>> getCourseAvgScores() {
        return scoreMapper.getCourseAvgScores();
    }
    
    public int delete(Integer id) {
        return scoreMapper.delete(id);
    }
}
