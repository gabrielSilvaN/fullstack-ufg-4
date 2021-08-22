package com.example.demo.repositories;

import com.example.demo.entities.Hospede;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HospedeRepository extends JpaRepository<Hospede, Integer> {
    
}
