package com.example.demo.business;

import com.example.demo.repositories.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Hotel;
import java.util.List;
import java.util.Optional;

@Service
public class HotelBusiness {
    @Autowired
    HotelRepository repository;

    public List<Hotel> findAll() {
        return this.repository.findAll();
    }

    public Hotel findById(Integer id) {
        Optional<Hotel> optHotel = this.repository.findById(id);
        Hotel hotel = optHotel.get();
        return hotel;
    }

    public Hotel insert(Hotel hotel) {

        return this.repository.save(hotel);
    }

    public Hotel update(Hotel hotel) {
        return this.repository.save(hotel);
    }

    public void delete(Integer id) {
        this.repository.deleteById(id);
    }

}
