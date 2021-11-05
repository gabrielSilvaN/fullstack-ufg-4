package com.example.demo.business;

import com.example.demo.repositories.HospedeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Hospede;
import java.util.List;
import java.util.Optional;

@Service
public class HospedeBusiness {
    @Autowired
    HospedeRepository repository;

    public Page<Hospede> paginatorFindAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Hospede> findAll() {
        return this.repository.findAll();
    }

    public Hospede findById(Integer id) {
        Optional<Hospede> optHospede = this.repository.findById(id);
        Hospede hospede = optHospede.get();
        return hospede;
    }

    public Hospede insert(Hospede hospede) {

        return this.repository.save(hospede);
    }

    public Hospede update(Hospede hospede) {
        return this.repository.save(hospede);
    }

    public void delete(Integer id) {
        this.repository.deleteById(id);
    }
}
