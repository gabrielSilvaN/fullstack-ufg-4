package com.example.demo.business;

import com.example.demo.repositories.QuartoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Quarto;
import java.util.List;
import java.util.Optional;

@Service
public class QuartoBusiness {
    @Autowired
    QuartoRepository repository;

    public List<Quarto> findAll() {
        return this.repository.findAll();
    }

    public Quarto findById(Integer id) {
        Optional<Quarto> optQuarto = this.repository.findById(id);
        Quarto quarto = optQuarto.get();
        return quarto;
    }

    public Quarto insert(Quarto quarto) {

        return this.repository.save(quarto);
    }

    public Quarto update(Quarto quarto) {
        return this.repository.save(quarto);
    }

    public void delete(Integer id) {
        this.repository.deleteById(id);
    }
}
