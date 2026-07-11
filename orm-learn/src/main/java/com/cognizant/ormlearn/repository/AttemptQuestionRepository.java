package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.AttemptQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttemptQuestionRepository extends JpaRepository<AttemptQuestion, Integer> {
}
