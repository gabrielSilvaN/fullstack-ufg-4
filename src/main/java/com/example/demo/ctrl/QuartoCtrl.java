package com.example.demo.ctrl;

import java.util.List;

import com.example.demo.business.QuartoBusiness;
import com.example.demo.entities.Quarto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "quarto")
public class QuartoCtrl {
    @Autowired
    QuartoBusiness business;

    @GetMapping
    public ResponseEntity<List<Quarto>> findAll() {
        List<Quarto> list = business.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quarto> findById(@PathVariable Integer id) {
        Quarto quarto = business.findById(id);
        return ResponseEntity.ok(quarto);
    }

    @PostMapping
    public ResponseEntity<Quarto> insert(@RequestBody Quarto h) {
        Quarto insertedQuarto = this.business.insert(h);
        return ResponseEntity.status(201).body(insertedQuarto);
    }

    @PutMapping
    public ResponseEntity<Quarto> update(@RequestBody Quarto h) {
        Quarto updatedQuarto = this.business.insert(h);
        return ResponseEntity.status(201).body(updatedQuarto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.business.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
