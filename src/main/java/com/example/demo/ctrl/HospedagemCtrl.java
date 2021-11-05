package com.example.demo.ctrl;

import java.util.List;

import com.example.demo.business.HospedagemBusiness;
import com.example.demo.entities.Hospedagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "hospedagem")
public class HospedagemCtrl {
    @Autowired
    HospedagemBusiness business;

    @GetMapping("/paginator")
    public ResponseEntity<Page<Hospedagem>> paginatorFindAll(Pageable pageable) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        Page<Hospedagem> retorno = null;
        try {
            retorno = business.paginatorFindAll(pageable);
            if (retorno.getSize() == 0) {
                headers.add("message", "A busca não encontrou nenhum registro de hospedagem(ns)!");
            }
        } catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", "Erro de sistema.");
        }
        return new ResponseEntity<>(retorno, headers, status);
    }

    @GetMapping
    public ResponseEntity<List<Hospedagem>> findAll() {
        List<Hospedagem> list = business.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospedagem> findById(@PathVariable Integer id) {
        Hospedagem hospedagem = business.findById(id);
        return ResponseEntity.ok(hospedagem);
    }

    @PostMapping
    public ResponseEntity<Hospedagem> insert(@RequestBody Hospedagem h) {
        Hospedagem insertedHospedagem = this.business.insert(h);
        return ResponseEntity.status(201).body(insertedHospedagem);
    }

    @PutMapping
    public ResponseEntity<Hospedagem> update(@RequestBody Hospedagem h) {
        Hospedagem updatedHospedagem = this.business.insert(h);
        return ResponseEntity.status(201).body(updatedHospedagem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.business.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
