package es.safareyes.cinetown.controladores;

import es.safareyes.cinetown.dtos.GeneroCarteleraDTO;
import es.safareyes.cinetown.servicios.GeneroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/generos")
@AllArgsConstructor
public class GeneroController {

    private GeneroService service;

    // Consultar géneros con el número de películas en cartelera
    @GetMapping
    public List<GeneroCarteleraDTO> consultarGenerosConPeliculasEnCartelera() {

        return service.consultarGenerosConPeliculasEnCartelera();

    }

}