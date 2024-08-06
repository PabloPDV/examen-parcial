package es.cic.curso.ejerc004.director;

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

import es.cic.curso.ejerc004.model.Director;
import es.cic.curso.ejerc004.service.DirectorService;

@SpringBootTest
@AutoConfigureMockMvc
public class DirectorControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DirectorService directorService;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Director director;

    private List<Director> directores = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        director = new Director();
        director.setId(12L);
        director.setNombre("Pedro");
        directores.add(directorService.crearDirector(director));
    }

    @AfterEach
    public void tearDown() {
        directores.remove(director);
    }

    @Test
    void testFindAll() throws Exception {
        mockMvc.perform(get("/api/directores"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").exists());

    }

    @Test
    void testFindById() throws Exception {
        mockMvc.perform(get("/api/directores/{id}", director.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(director.getId()))
                .andExpect(jsonPath("$.nombre").value(director.getNombre()));
    }

    @Test
    void testCrearDirector() throws Exception {
        Director directorNuevo = new Director();
        directorNuevo.setId(12L);
        directorNuevo.setNombre("test");

        mockMvc.perform(post("/api/directores")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(directorNuevo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.nombre").value(directorNuevo.getNombre()));
    }

    @Test
    void testActualizarDirector() throws Exception {
        director.setNombre("name");

        mockMvc.perform(put("/api/directores")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(director)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.nombre").value("name"));
    }

    @Test
    void testEliminarDirector() throws Exception {
        mockMvc.perform(delete("/api/directores/{id}", director.getId()))
                .andExpect(status().isOk());
    }

}
