package es.cic.curso.ejerc005.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.ejerc005.model.Sesion;
import es.cic.curso.ejerc005.repository.SesionRepository;

@Service
@Transactional
public class SesionService {
    
    @Autowired
    private SesionRepository sesionRepository;

    @Transactional(readOnly =  true)
    public Integer capacidadDisponible(long numeroSesion) {
        return sesionRepository.butacasLibres(numeroSesion);
    }

    public Sesion actualizarSesion(Sesion sesion) {
        return sesionRepository.save(sesion);
    }
}
