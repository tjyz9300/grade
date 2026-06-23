package com.score.controller;

import com.score.entity.Course;
import com.score.service.CourseService;
import com.score.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 课程控制器
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private TeacherService teacherService;
    
    // 课程列表
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "course/list";
    }
    
    // 新增课程页面
    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        return "course/add";
    }
    
    // 保存课程
    @PostMapping("/save")
    public String save(Course course) {
        courseService.save(course);
        return "redirect:/course/list";
    }
    
    // 删除课程
    @GetMapping("/delete/{courseId}")
    public String delete(@PathVariable String courseId) {
        courseService.delete(courseId);
        return "redirect:/course/list";
    }
}
