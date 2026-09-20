package com.faizan.questionservices.dao;

import com.faizan.questionservices.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
public interface QuestionDao extends JpaRepository<Question,Integer>{
    List<Question>findByCategory(String category);
    @Query(value = "SELECT q.id   FROM  question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Integer> findRandomQuestionByCategory(String category, int numQ);
}
