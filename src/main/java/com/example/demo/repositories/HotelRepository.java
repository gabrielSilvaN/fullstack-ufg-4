package com.example.demo.repositories;

import com.example.demo.entities.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    
}
