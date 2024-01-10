package com.example.firstpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/hi")
    public String niceToMeetYou(Model model){
        model.addAttribute("username", "YeoGyeong");
        return"greetings"; //greetings.mustache 파일을 찾아 웹 브라우저로 전송
    }
}
