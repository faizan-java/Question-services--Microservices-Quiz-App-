package com.faizan.quizapp.controller;

import com.faizan.quizapp.model.Question;
import com.faizan.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("allquestions")
    public ResponseEntity<List<Question>> getQuestionName(){
        return questionService.getAllQuestion();
    }
    @GetMapping("category/{message}")
    public ResponseEntity<List<Question>> getQuestionByCategory( @PathVariable("message") String category){
        return questionService.getQuestionsByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
      return questionService.addQuestion(question);
    }
}
