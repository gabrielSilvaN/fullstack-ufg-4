package com.example.demo.repositories;

import com.example.demo.entities.Hospedagem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HospedagemRepository extends JpaRepository<Hospedagem, Integer> {
    
}
