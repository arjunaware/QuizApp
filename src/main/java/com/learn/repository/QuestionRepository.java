package com.learn.repository;

import com.learn.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer>
{

    public List<Question> findByCategory(String category);

    //vative Query
    @Query(
            value = "SELECT * FROM mcq_questions q WHERE q.category = ?1 ORDER BY RAND() LIMIT ?2",
            nativeQuery = true
    )
    List<Question> findRandomQuestionsByCategory(String category, int numQ);

}