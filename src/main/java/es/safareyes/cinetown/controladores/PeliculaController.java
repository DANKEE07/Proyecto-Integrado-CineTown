package es.safareyes.cinetown.controladores;

import es.safareyes.cinetown.dtos.CrearPeliculaDTO;
import es.safareyes.cinetown.dtos.PeliculaDTO;
import es.safareyes.cinetown.servicios.PeliculaService;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/peliculas")
@AllArgsConstructor

public class PeliculaController {

    private PeliculaService peliculaService;

    @GetMapping("/{id}")
    public PeliculaDTO consultarPorId(@PathVariable Integer id) {
        return peliculaService.consultarPorIdConGeneros(id);
    }

    @Transactional(readOnly = true)
    @GetMapping()
    public Page<PeliculaDTO> buscarTodasLasPeliculas(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable page) {
        return peliculaService.buscarTodasLasPeliculas(page);
    }

    @PostMapping()
    public PeliculaDTO crearPelicula(@Valid @RequestBody CrearPeliculaDTO dto) {
        return peliculaService.crearPelicula(dto);
    }

    @PutMapping("/{id}")
    public PeliculaDTO modificarPelicula(@PathVariable Integer id, @Valid @RequestBody CrearPeliculaDTO dto) {
        return peliculaService.modificarPelicula(id, dto);
    }

}
