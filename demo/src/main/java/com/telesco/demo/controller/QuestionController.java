package com.telesco.demo.controller;

import com.telesco.demo.model.Question;
import com.telesco.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

@Autowired
QuestionService questionService;
    @GetMapping("AllQuestions")
    public ResponseEntity<List<Question>> getQuestions()
    {

        return questionService.getAllQuestions();
    }

    @GetMapping("difficultLevel/{difficultLevel}")
    public ResponseEntity<List<Question>> findBydifficultLevel(@PathVariable String difficultLevel)
    {
        return questionService.getquestionsBydifficultLevel(difficultLevel);
    }

    @PostMapping("add")
    public ResponseEntity<String> Addquestion(@RequestBody Question question)
    {
        return questionService.Addquestion(question);
    }
    @DeleteMapping("delete/{id}")
        public String DeletQuestion(@PathVariable int id){
       return  questionService.deletedById(id);
    }

}
