package com.telesco.demo.dao;

import com.telesco.demo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

   // static List<Question> findRandomQuestionsBYlevel(String level, int numQ) ;

    // @Query(value = "SELECT * FROM question q Where q.level=:level ORDER BY random()limit:numQ",nativeQuery = true)
    @Query(value = "SELECT * FROM question q WHERE q.level = :level ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsBylevel(String level, int numQ);

    List<Question> findBydifficultLevel(String difficultLevel);
    void deleteById(Integer id);
}
