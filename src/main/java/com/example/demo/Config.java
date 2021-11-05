package com.example.demo;

import com.example.demo.entities.Hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.demo.entities.Hospede;

import com.example.demo.repositories.HospedeRepository;
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

    @Autowired
    private HospedeRepository hospedeRepository;

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i <= 100; i++) {
            Hotel h = null;
            if (i % 2 == 0)
                h = new Hotel(null, "Palace Hotel " + i, "Avenida Goiás - Centro", 5);
            if (i % 2 != 0)
                h = new Hotel(null, "Grande Hotel " + i, "Rua 3 - Centro", 3);

            hotelRepository.save(h);

        }

        hospedeRepository.save(createHospede("Gabriel Silva", "1996-11-16", 1234));
        hospedeRepository.save(createHospede("Gabriel Olegário", "1996-12-16", 1235));

    }

    public Hospede createHospede(String name, String data, Integer cpf) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(data);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Hospede hospede1 = new Hospede(null, name, sqlDate, cpf);

        return hospede1;
    }
}
