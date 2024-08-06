package es.cic.curso.ejerc004.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import es.cic.curso.ejerc004.model.Pelicula;

@Service
public class PeliculaService {
    
    private List<Pelicula> peliculas = new ArrayList<>();

    public Pelicula crearPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        return pelicula;
    }
    public List<Pelicula> obtenerPeliculas() {
        return peliculas;
    }

    public Pelicula findPeliculaById(long id) {
        return peliculas.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public Pelicula actualizarPelicula(Pelicula pelicula) {
        Pelicula peliculaOriginal = findPeliculaById(pelicula.getId());
        if (peliculaOriginal != null) {
            peliculaOriginal.setTitulo(pelicula.getTitulo());
            peliculaOriginal.setFechaNacimiento(pelicula.getFechaNacimiento());
        }
        return pelicula;
    }

    public void eliminarPelicula(long id) {
        peliculas.removeIf(p -> p.getId().equals(id));
    }
}
