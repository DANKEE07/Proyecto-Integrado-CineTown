package es.safareyes.cinetown.controladores;

import es.safareyes.cinetown.dtos.PeliculaDTO;
import es.safareyes.cinetown.servicios.PeliculaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/peliculas")
@AllArgsConstructor

public class PeliculaController {

    private PeliculaService service;

    @GetMapping("/{id}")
    public PeliculaDTO consultarPorId(@PathVariable Integer id) {
        return service.consultarPorIdConGeneros(id);
    }

}
