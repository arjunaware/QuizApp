package com.learn.service;

import com.learn.model.Question;
import com.learn.model.QuestionWrapper;
import com.learn.model.Quiz;
import com.learn.model.Response;
import com.learn.repository.QuestionRepository;
import com.learn.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category, numQ);
        System.out.println(questions + "--------------------");
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.OK);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questionsFromDb = quiz.get().getQuestions();

        List<QuestionWrapper> allQuestions = new ArrayList<>();
        for (Question que : questionsFromDb) {
            QuestionWrapper rapperQue = new QuestionWrapper(que.getId(), que.getQuestionTitle(), que.getOption1(), que.getOption2(), que.getOption3(), que.getOption4());
            allQuestions.add(rapperQue);
        }

        return new ResponseEntity<>(allQuestions, HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculate(Integer id, List<Response> responses) {

        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        List<Question> questions = quiz.getQuestions();
        int rightAns = 0;

        for (Response res : responses) {
            for (Question q : questions) {
                if (q.getId() == res.getId() && q.getRightAnswer().equals(res.getResponse())) {
                    rightAns++;
                }
            }
        }
        return new ResponseEntity<>(rightAns, HttpStatus.OK);
    }
}

    /*


    public ResponseEntity<Integer> calculate(Integer id, List<Response> responses) {

        Quiz quiz = quizRepository.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int rightAns=0;
        int i=0;
        for(Response res:responses)
        {
            if(res.getResponse().equals(questions.get(i).getRightAnswer()))
            {
                rightAns++;
            }
            i++;
        }
        return new ResponseEntity<>(rightAns,HttpStatus.OK);
    }

     */
}
