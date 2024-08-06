package es.cic.curso.ejerc005.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso.ejerc005.model.Sala;
import es.cic.curso.ejerc005.service.SalaService;

@RestController
@RequestMapping("/api/salas")
public class SalaController {
    
    @Autowired
    private SalaService salaService;

    @GetMapping
    public List<Sala> listarSalas() {
        return salaService.findAll();
    }

    @GetMapping("/{id}")
    public Sala findSalaById(@PathVariable("id") long id) {
        return salaService.findSalaById(id);
    }    

}
