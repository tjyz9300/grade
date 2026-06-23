package com.score.controller;

import com.score.entity.*;
import com.score.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Vector;

/**
 * 教师控制器
 * 教师可以上多门课程，教师可以给多个学生上课，教师可查询自己任课课程的成绩
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    
    @Autowired
    private TeacherService teacherService;
    
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private ScoreService scoreService;
    
    // 教师列表
    @GetMapping("/list")
    public String list(Model model) {
        List<Teacher> teachers = teacherService.findAll();
        // 使用Vector存储教师列表
        Vector<Teacher> teacherVector = new Vector<>(teachers);
        model.addAttribute("teachers", teacherVector);
        return "teacher/list";
    }
    
    // 教师可查询自己任课课程的成绩
    @GetMapping("/scores/{teacherId}")
    public String myCourseScores(@PathVariable String teacherId, Model model) {
        Teacher teacher = teacherService.findById(teacherId);
        List<Score> scores = scoreService.findByTeacherId(teacherId);
        model.addAttribute("teacher", teacher);
        model.addAttribute("scores", scores);
        return "teacher/scores";
    }
    
    // 教师给学生打分页面
    @GetMapping("/giveScore/{teacherId}")
    public String giveScorePage(@PathVariable String teacherId, Model model) {
        Teacher teacher = teacherService.findById(teacherId);
        // 教师可以上多门课程
        List<Course> courses = courseService.findByTeacherId(teacherId);
        // 教师可以给多个学生上课
        List<Student> students = studentService.findAll();
        
        model.addAttribute("teacher", teacher);
        model.addAttribute("courses", courses);
        model.addAttribute("students", students);
        return "teacher/giveScore";
    }
    
    // 教师给学生打分（成绩必须教师给出）
    @PostMapping("/giveScore")
    public String giveScore(Score score, String teacherId) {
        scoreService.giveScore(score);
        return "redirect:/teacher/scores/" + teacherId;
    }
    
    // 新增教师页面
    @GetMapping("/add")
    public String addPage() {
        return "teacher/add";
    }
    
    // 保存教师
    @PostMapping("/save")
    public String save(Teacher teacher) {
        teacherService.save(teacher);
        return "redirect:/teacher/list";
    }
    
    // 删除教师
    @GetMapping("/delete/{teacherId}")
    public String delete(@PathVariable String teacherId) {
        teacherService.delete(teacherId);
        return "redirect:/teacher/list";
    }
}
