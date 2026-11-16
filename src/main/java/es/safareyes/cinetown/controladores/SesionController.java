package es.safareyes.cinetown.controladores;

import es.safareyes.cinetown.dtos.CrearSesionDTO;
import es.safareyes.cinetown.dtos.SesionDTO;
import es.safareyes.cinetown.servicios.SesionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class SesionController {

    private final SesionService sesionService;


    @PostMapping("/api/v1/sesiones")
    public SesionDTO crearSesionPelicula(@Valid @RequestBody CrearSesionDTO dto) {
        return sesionService.crearSesion(dto);
    }



    @GetMapping("/api/v1/sesiones")
    public List<SesionDTO> buscarSesiones(
            @RequestParam(required = false) LocalDate fecha,
            @RequestParam(required = false) Integer peliculaId
    ) {

        return sesionService.buscarSesionesConPeliculaYAsientos(fecha, peliculaId);

    }



    @GetMapping("/api/v1/sesiones/{id}")
    public SesionDTO buscarSesionPorId(@PathVariable Integer id) {
        return sesionService.consultarSesionPorId(id);
    }



}
