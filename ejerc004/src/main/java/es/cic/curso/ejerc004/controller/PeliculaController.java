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

import es.cic.curso.ejerc004.model.Pelicula;
import es.cic.curso.ejerc004.service.PeliculaService;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> obtenerPeliculas() {
        List<Pelicula> peliculas = peliculaService.obtenerPeliculas();
        return peliculas;
    }

    @GetMapping("/{id}")
    public Pelicula findPeliculaById(@PathVariable("id") long id) {
        return peliculaService.findPeliculaById(id);
    }

    @PostMapping
    public Pelicula crearPelicula(@RequestBody Pelicula pelicula) {
       return  peliculaService.crearPelicula(pelicula);   
    }

    @PutMapping
    public Pelicula actualizarPelicula(@RequestBody Pelicula pelicula) {
       return peliculaService.actualizarPelicula(pelicula);
    }

    @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable long id) {
        peliculaService.eliminarPelicula(id);
    }
}
