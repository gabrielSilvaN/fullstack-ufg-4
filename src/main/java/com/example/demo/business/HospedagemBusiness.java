package com.example.demo.business;

import com.example.demo.repositories.HospedagemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Hospedagem;
import java.util.List;
import java.util.Optional;

@Service
public class HospedagemBusiness {

    @Autowired
    HospedagemRepository repository;

    public List<Hospedagem> findAll() {
        return this.repository.findAll();
    }

    public Hospedagem findById(Integer id) {
        Optional<Hospedagem> optHospedagem = this.repository.findById(id);
        Hospedagem hospedagem = optHospedagem.get();
        return hospedagem;
    }

    public Hospedagem insert(Hospedagem hospedagem) {

        return this.repository.save(hospedagem);
    }

    public Hospedagem update(Hospedagem hospedagem) {
        return this.repository.save(hospedagem);
    }

    public void delete(Integer id) {
        this.repository.deleteById(id);
    }
}
