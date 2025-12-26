package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Suggestion;

@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {
}
