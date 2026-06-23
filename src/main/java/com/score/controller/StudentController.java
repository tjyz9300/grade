package com.score.controller;

import com.score.entity.Student;
import com.score.entity.Score;
import com.score.service.StudentService;
import com.score.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Vector;

/**
 * 学生控制器
 * 学生可以查询自己的成绩
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private ScoreService scoreService;
    
    // 学生列表
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student/list";
    }
    
    // 学生查询自己的成绩
    @GetMapping("/scores/{studentId}")
    public String myScores(@PathVariable String studentId, Model model) {
        Student student = studentService.findById(studentId);
        List<Score> scoreList = scoreService.findByStudentId(studentId);
        // 使用Vector存储成绩（复习vector的使用）
        Vector<Score> scores = new Vector<>(scoreList);
        student.setScores(scores);
        
        // 计算平均分
        double avgScore = scores.stream()
                .mapToDouble(Score::getScore)
                .average()
                .orElse(0.0);
        
        model.addAttribute("student", student);
        model.addAttribute("scores", scores);
        model.addAttribute("avgScore", String.format("%.2f", avgScore));
        return "student/scores";
    }
    
    // 新增学生页面
    @GetMapping("/add")
    public String addPage() {
        return "student/add";
    }
    
    // 保存学生
    @PostMapping("/save")
    public String save(Student student) {
        studentService.save(student);
        return "redirect:/student/list";
    }
    
    // 删除学生
    @GetMapping("/delete/{studentId}")
    public String delete(@PathVariable String studentId) {
        studentService.delete(studentId);
        return "redirect:/student/list";
    }
}
