package es.cic.curso.ejerc005.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.ejerc005.model.Sala;
import es.cic.curso.ejerc005.repository.SalaRepository;

@Service
@Transactional
public class SalaService {
    
    @Autowired
    private SalaRepository salaRepository;

    @Transactional(readOnly = true)
    public List<Sala> findAll() {
        return salaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Sala findSalaById(long id) {
        return salaRepository.findById(id).orElse(null);
    }
    
    public Sala actualizarSala(Sala sala) {
        return salaRepository.save(sala);
    }
    
    public Sala crearSala(Sala sala) {
        return salaRepository.save(sala);
    }

    public void eliminarSala(long id) {
        salaRepository.deleteById(id);
    }

}
