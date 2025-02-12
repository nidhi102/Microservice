package com.telesco.demo.controller;

import com.telesco.demo.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> CreateQuiz(@RequestParam String level, @RequestParam int numQ, @RequestParam String title) {
        //return new ResponseEntity<>("I am here", HttpStatus.OK);
        return quizService.createQuiz(level, numQ, title);
    }
}
