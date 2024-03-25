package com.telesco.demo.service;

import com.telesco.demo.model.Question;
import com.telesco.demo.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getquestionsBydifficultLevel(String difficultLevel) {

        try {
            return new ResponseEntity<>(questionDao.findBydifficultLevel(difficultLevel), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> Addquestion(Question question) {
      questionDao.save(question);
        return new ResponseEntity<>("added successfully",HttpStatus.CREATED);
    }

    public String deletedById(int id) {
        questionDao.deleteById(id);
        return "deleted";
    }
}
