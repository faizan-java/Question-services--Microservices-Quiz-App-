package com.faizan.quizapp.dao;

import com.faizan.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
public interface QuestionDao extends JpaRepository<Question,Integer>{
    List<Question>findByCategory(String category);
    @Query(value = "SELECT *   FROM  question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, int numQ);
}
