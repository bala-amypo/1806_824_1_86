package com.example.demo.repository;

import com.example.demo.entity.Suggestion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {

    List<Suggestion> findByFarmId(Long farmId);
}
