package es.cic.curso.ejerc005.session;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.ejerc005.model.Sesion;
import es.cic.curso.ejerc005.service.SesionService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
@Transactional
@Disabled
public class SessionServiceIT {
    
     @PersistenceContext
    private EntityManager em;

    @Autowired
    private SesionService cut;

    private Sesion sesion;

    @BeforeEach
    public void setUp() {
        sesion = new Sesion();
        sesion.setCapacidad(1);
        em.persist(sesion);
        em.flush();
    }

    @AfterEach
    public void tearDown() {
        if (sesion != null) {
            em.remove(sesion);
            em.flush();
        }
    }

    @Test
    void testFindAll() {
        // When
        List<Sesion> result = cut.findAll();

        // Then
        assertNotNull(result);
    }

    @Test
    void testUsuarioById() {
        // When
        Sesion result = cut.findSesionById(sesion.getId());

        // Then
        assertNotNull(result);
    }
}
