package es.cic.curso.ejerc005.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Sesion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int capacidad;

    @OneToOne(mappedBy = "sesion")
    private Sala sala;

    public Sesion() {
    }

    public Sesion(Long id, int capacidad, Sala sala) {
        this.id = id;
        this.capacidad = capacidad;
        this.sala = sala;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    
}
