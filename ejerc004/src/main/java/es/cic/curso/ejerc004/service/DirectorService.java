package es.cic.curso.ejerc004.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import es.cic.curso.ejerc004.model.Director;

@Service
public class DirectorService {

    private List<Director> directores = new ArrayList<>();

    public List<Director> findAll() {
        return directores;
    }

    public Director crearDirector(Director director) {
        directores.add(director);
        return director;
    }

    public Director findDirectorById(long id) {
        return directores.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    public Director actualizarDirector(Director director) {
        Director directorOriginal = findDirectorById(director.getId());
        if (directorOriginal != null) {
            directorOriginal.setNombre(director.getNombre());
            directorOriginal.setFechaNacimiento(director.getFechaNacimiento());
        }

        return directorOriginal;
    }

    public void eliminarDirector(long id) {
        directores.removeIf(d -> d.getId().equals(id));
    }
}
