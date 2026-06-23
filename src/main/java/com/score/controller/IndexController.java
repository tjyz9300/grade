package com.score.controller;

import com.score.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页控制器
 */
@Controller
public class IndexController {
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private TeacherService teacherService;
    
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private ScoreService scoreService;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("courses", courseService.findAll());
        model.addAttribute("studentAvgScores", scoreService.getStudentAvgScores());
        model.addAttribute("courseAvgScores", scoreService.getCourseAvgScores());
        return "index";
    }
}
