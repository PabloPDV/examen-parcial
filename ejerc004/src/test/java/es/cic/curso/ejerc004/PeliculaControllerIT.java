package es.cic.curso.ejerc004;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.curso.ejerc004.model.Pelicula;
import es.cic.curso.ejerc004.service.PeliculaService;

@SpringBootTest
@AutoConfigureMockMvc
public class PeliculaControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PeliculaService peliculaService;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Pelicula pelicula;

    private List<Pelicula> peliculas = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        pelicula = new Pelicula();
        pelicula.setId(12L);
        pelicula.setTitulo("Pedro");
        peliculas.add(peliculaService.crearPelicula(pelicula));
    }

    @AfterEach
    public void tearDown() {
        peliculas.remove(pelicula);
    }

    @Test
    void testFindAll() throws Exception {
        mockMvc.perform(get("/api/peliculas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").exists());

    }

    @Test
    void testFindById() throws Exception {
        mockMvc.perform(get("/api/peliculas/{id}", pelicula.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(pelicula.getId()))
                .andExpect(jsonPath("$.titulo").value(pelicula.getTitulo()));
    }

    @Test
    void testCrearUsuario() throws Exception {
        Pelicula peliculaNuevo = new Pelicula();
        peliculaNuevo.setId(12L);
        peliculaNuevo.setTitulo("test");

        mockMvc.perform(post("/api/peliculas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(peliculaNuevo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.titulo").value(peliculaNuevo.getTitulo()));
    }

    @Test
    void testActualizarUsuario() throws Exception {
        pelicula.setTitulo("title");

        mockMvc.perform(put("/api/peliculas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pelicula)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.titulo").value("title"));
    }

    @Test
    void testEliminarUsuario() throws Exception {
        mockMvc.perform(delete("/api/peliculas/{id}", pelicula.getId()))
                .andExpect(status().isOk());
    }
}
