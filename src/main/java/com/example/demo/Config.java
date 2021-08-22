package com.example.demo;

import com.example.demo.entities.Hotel;
import com.example.demo.repositories.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class Config implements CommandLineRunner {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public void run(String... args) throws Exception {
        Hotel h1 = new Hotel(null, "Palace Hotel", "Avenida Goiás - Centro", 5);
        Hotel h2 = new Hotel(null, "Grande Hotel", "Rua 3 - Centro", 3);
        Hotel h3 = new Hotel(null, "Ibis", "Av. Ahanguera", 4);

        hotelRepository.save(h1);
        hotelRepository.save(h2);
        hotelRepository.save(h3);

    }
}
