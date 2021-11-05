package com.example.demo.ctrl;

import java.util.List;

import com.example.demo.business.HospedeBusiness;
import com.example.demo.entities.Hospede;

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
@RequestMapping(value = "hospede")
public class HospedeCtrl {

    @Autowired
    HospedeBusiness business;

    @GetMapping("/paginator")
    public ResponseEntity<Page<Hospede>> paginatorFindAll(Pageable pageable) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        Page<Hospede> retorno = null;
        try {
            retorno = business.paginatorFindAll(pageable);
            if (retorno.getSize() == 0) {
                headers.add("message", "A busca não encontrou nenhum registro de hospede(s)!");
            }
        } catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", "Erro de sistema.");
        }
        return new ResponseEntity<>(retorno, headers, status);
    }

    @GetMapping
    public ResponseEntity<List<Hospede>> findAll() {
        List<Hospede> list = business.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospede> findById(@PathVariable Integer id) {
        Hospede hospede = business.findById(id);
        return ResponseEntity.ok(hospede);
    }

    @PostMapping
    public ResponseEntity<Hospede> insert(@RequestBody Hospede h) {
        Hospede insertedHospedagem = this.business.insert(h);
        return ResponseEntity.status(201).body(insertedHospedagem);
    }

    // @PostMapping
    // public String insert(@RequestBody Hospede h) {

    // System.out.println(h);
    // return "Deu bom";
    // }

    @PutMapping
    public ResponseEntity<Hospede> update(@RequestBody Hospede h) {
        Hospede updatedHospede = this.business.insert(h);
        return ResponseEntity.status(201).body(updatedHospede);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.business.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
