package com.example.demo.repositories;

import com.example.demo.entities.Quarto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartoRepository extends JpaRepository<Quarto, Integer> {
    
}
