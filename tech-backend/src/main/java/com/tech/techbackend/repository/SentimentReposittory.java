package com.tech.techbackend.repository;

import com.tech.techbackend.entities.Sentiment;
import com.tech.techbackend.enums.TypeSentiment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentimentReposittory extends JpaRepository<Sentiment,Integer> {
    List<Sentiment> findByType(TypeSentiment type);
}
