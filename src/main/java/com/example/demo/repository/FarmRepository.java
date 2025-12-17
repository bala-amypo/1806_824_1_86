package com.example.demo.repository;

import com.example.demo.entity.Farm;
import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {

    List<Farm> findByOwner(User owner);

    Optional<Farm> findById(Long id);
}
