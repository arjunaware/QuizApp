package com.learn;

import com.learn.model.Question;
import com.learn.service.QuestionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class QuizAppApplication {

	public static void main(String[] args) {



        /*

{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;
    private String difficulty;
    private String uestion_title;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String right_answer;
}

/*
CREATE TABLE mcq_questions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    category VARCHAR(50),
    difficulty VARCHAR(20),
    question_title VARCHAR(255),
    option1 VARCHAR(255),
    option2 VARCHAR(255),
    option3 VARCHAR(255),
    option4 VARCHAR(255),
    right_answer VARCHAR(255)
);

         */
        ConfigurableApplicationContext context = SpringApplication.run(QuizAppApplication.class, args);

      /*  var service = context.getBean(QuestionService.class);
        Question que =new Question();
        que.setCategory("Human Resources");
        que.setDifficulty("Very Diffcult");
        que.setQuestion_title("What is ment by Human Resource");
        que.setOption1("general");
        que.setOption2("normal");
        que.setOption3("individual");
        que.setOption4("general");
        que.setRight_answer("individual");

        service.addQuesstion(que);



       */

    }

}
