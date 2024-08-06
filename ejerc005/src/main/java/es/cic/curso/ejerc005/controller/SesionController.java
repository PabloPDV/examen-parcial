package es.cic.curso.ejerc005.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso.ejerc005.model.Sesion;
import es.cic.curso.ejerc005.service.SesionService;

@RestController
@RequestMapping("/api/sesiones")
public class SesionController {
    
    @Autowired
    private SesionService sesionService;

    @GetMapping("/asientos-disponibles/{numeroSesion}")
    public Integer numeroAsientosDisponibles(@PathVariable("numeroSesion") long numeroSesion) {
        return sesionService.capacidadDisponible(numeroSesion);
    }

    @PutMapping
    public Sesion actualizarSesion(@RequestBody Sesion sesion) {
        return sesionService.actualizarSesion(sesion);
    }
}
