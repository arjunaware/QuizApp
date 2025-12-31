package com.learn.service;

import com.learn.model.Question;
import com.learn.model.Quiz;
import com.learn.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService
{
    @Autowired
    private QuestionRepository questionRepository;
    
    
    public ResponseEntity<List<Question>> getAllQuestions()
    {
        try
        {
            return new ResponseEntity(questionRepository.findAll(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            System.out.println(e);
            return new ResponseEntity(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Question>> fetchByCategory(String category)
    {
        try
        {
            return new ResponseEntity(questionRepository.findAll(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            System.out.println(e);
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

        }
    }

    public ResponseEntity<Question> addQuestion(Question que)
    {
        try
        {
            System.out.println("Question Added Successfully");
            return new ResponseEntity<>(questionRepository.save(que),HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new Question(),HttpStatus.BAD_REQUEST);
        }

    }


    public ResponseEntity<Question> UpdateQuestion(Question que)
    {
       try
       {
           System.out.println("Question Updated Successfully");
           return new ResponseEntity<>(questionRepository.save(que),HttpStatus.CREATED);
       }
       catch (Exception e)
       {
           return new ResponseEntity<>(new Question(),HttpStatus.NOT_FOUND);

       }

    }


    public  ResponseEntity<String> deleteQuestion(int id)
    {
        try {
            if (!questionRepository.existsById(id)) {
                return new ResponseEntity<>("Question Not Found", HttpStatus.NOT_FOUND);
            }

            questionRepository.deleteById(id);
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);

        }
       catch (Exception e)
       {
           return new ResponseEntity<>("Something Went Wrong ",HttpStatus.NOT_FOUND);

       }

    }



}
