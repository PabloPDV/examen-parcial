package es.cic.curso.ejerc005.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.cic.curso.ejerc005.model.Sesion;

public interface SesionRepository extends JpaRepository<Sesion,Long> {
    
    @Query(value = "SELECT s.capacidad FROM Sesion s WHERE s.id =:numeroSesion")
    Integer butacasLibres(@Param(value = "numSesion")long numeroSesion);
}
