package es.cic.curso.ejerc005.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.cic.curso.ejerc005.model.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long>{

    @Query(value = "SELECT s.sesion.capacidad FROM Sala s")
    List<Sala>  capacidadActualSala();
} 
