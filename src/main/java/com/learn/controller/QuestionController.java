package com.learn.controller;

import com.learn.model.Question;
import com.learn.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/allque")
    public ResponseEntity<List<Question>> getAllQue()
    {
        return new ResponseEntity(questionService.getAllQuestions(),HttpStatus.OK);
    }


    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> fetchByCategory(@PathVariable("category") String category)
    {
        return questionService.fetchByCategory(category);
    }


    @PostMapping("/add")
    public ResponseEntity<Question> addStudent(@RequestBody Question question)
    {
      return questionService.addQuestion(question);

    }


    @PutMapping("/update")
    public ResponseEntity<Question> updateQue(@RequestBody Question que)
    {
        System.out.println("Updated Successfully");
        return questionService.UpdateQuestion(que);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> updateQue(@PathVariable("id") int id)
    {
      return   questionService.deleteQuestion(id);
    }


}
