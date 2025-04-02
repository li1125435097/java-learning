package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Controller
public class HomeController {

    @GetMapping("/hello")
    public String home(Model model) {
        // 使用文本块
        String message = """
            Hello from Spring MVC 6!
            Running on JDK 17
            """;
        
        model.addAttribute("message", message);
        return "home";
    }

    @ResponseBody
    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Long id) {
        // 返回User对象会自动转换为JSON
        return "user"+id;
    }

    @ResponseBody
    @GetMapping(value = "/user",produces = "application/json;charset=UTF-8")
    public String getUser(@RequestParam String name) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserMapper userMapper = context.getBean(UserMapper.class);
        User user = userMapper.findById(Long.valueOf(1));
        // 返回User对象会自动转换为JSON
        return "user"+name+user.getName();
    }
    
    // 使用record作为DTO
    public record UserInfo(String name, int age) {}
}