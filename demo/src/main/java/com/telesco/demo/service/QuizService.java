package com.telesco.demo.service;

import com.telesco.demo.dao.QuestionDao;
import com.telesco.demo.dao.QuizDao;
import com.telesco.demo.model.Question;
import com.telesco.demo.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {


    @Autowired
    QuizDao quizDao;
    @Autowired
   QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String level, int numQ, String title) {
        List<Question> questions= questionDao.findRandomQuestionsBylevel(level,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>(" Success", HttpStatus.CREATED);
    }


}
