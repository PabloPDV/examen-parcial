package es.cic.curso.ejerc004.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso.ejerc004.model.Director;
import es.cic.curso.ejerc004.service.DirectorService;

@RestController
@RequestMapping("/api/directores")
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @GetMapping
    public List<Director> obtenerDirectors() {
        return directorService.findAll();
    }

    @GetMapping("/{id}")
    public Director findDirectorById(@PathVariable("id") long id) {
        return directorService.findDirectorById(id);
    }

    @PostMapping
    public Director crearPelicula(@RequestBody Director director) {
        return directorService.crearDirector(director);
    }

    @PutMapping
    public Director actualizarPelicula(@RequestBody Director director) {
        return directorService.actualizarDirector(director);
    }

    @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable long id) {
        directorService.eliminarDirector(id);
    }
}
