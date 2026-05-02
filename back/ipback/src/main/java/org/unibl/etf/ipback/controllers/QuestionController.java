package org.unibl.etf.ipback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ipback.entities.QuestionEntity;
import org.unibl.etf.ipback.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public List<QuestionEntity> getAll(){
        return questionService.getAll();
    }

    @GetMapping("/question/{id}")
    public List<QuestionEntity> getById(@PathVariable Integer id){
        return questionService.getQuestionById(id);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody QuestionEntity questionEntity){
        questionService.updateQuestion(questionEntity);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody QuestionEntity questionEntity){
        questionService.createQuestion(questionEntity);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
    }
}
