package es.safareyes.cinetown.controladores;

import es.safareyes.cinetown.dtos.CrearSesionDTO;
import es.safareyes.cinetown.dtos.SesionDTO;
import es.safareyes.cinetown.modelos.Sesion;
import es.safareyes.cinetown.servicios.SesionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SesionController {

    private final SesionService sesionService;

    @PostMapping("/api/v1/sesiones")
    public SesionDTO crearSesionPelicula(@Valid @RequestBody CrearSesionDTO dto) {
        return sesionService.crearSesion(dto);
    }

}
