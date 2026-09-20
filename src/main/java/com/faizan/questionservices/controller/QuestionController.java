package com.faizan.questionservices.controller;
import com.faizan.questionservices.model.Question;
import com.faizan.questionservices.model.QuestionWrapper;
import com.faizan.questionservices.model.Response;
import com.faizan.questionservices.services.QuestionService;
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
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable("message") String category){
        return questionService.getQuestionsByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
      return questionService.addQuestion(question);
    }
    // generate
    @GetMapping("generate")
    public ResponseEntity<List<Integer>>getQuestionForQuiz
    (@RequestParam  String categoryName , @RequestParam Integer numQuestion){
        return questionService.getQuestionForQuiz(categoryName,numQuestion);
    }
    // getQuestion (questionId)
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getAllQuestions(@RequestBody List<Integer> questionIds){
        return questionService.getQuestionsFromId(questionIds);
    }
    // getScores
    @PostMapping("getScores")
    public ResponseEntity<Integer> getScores(@RequestBody List<Response> responses){
        return questionService.getScores(responses);
    }

}
