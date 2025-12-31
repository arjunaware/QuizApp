package com.learn.controller;

import com.learn.model.QuestionWrapper;
import com.learn.model.Response;
import com.learn.service.QuestionService;
import com.learn.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
   private QuizService quizService;


    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int num,@RequestParam String title)
    {
        return  quizService.createQuiz(category,num,title);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>>getQuizQuestion(@PathVariable Integer id)
    {
       return quizService.getQuizQuestion(id);

    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> postResult(@PathVariable Integer id, @RequestBody List<Response> responses)
    {
        return quizService.calculate(id,responses);
    }
}
