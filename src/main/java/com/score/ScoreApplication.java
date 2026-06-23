package com.score;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 成绩管理系统启动类
 * 使用SpringBoot + MyBatis + MySQL实现
 */
@SpringBootApplication
@MapperScan("com.score.mapper")
public class ScoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScoreApplication.class, args);
        System.out.println("=================================");
        System.out.println("  成绩管理系统启动成功！");
        System.out.println("  访问地址: http://localhost:8080");
        System.out.println("=================================");
    }
}
