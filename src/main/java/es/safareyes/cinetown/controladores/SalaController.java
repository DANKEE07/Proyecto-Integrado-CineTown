package es.safareyes.cinetown.controladores;

import es.safareyes.cinetown.dtos.SalaDTO;
import es.safareyes.cinetown.servicios.SalaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salas")
@AllArgsConstructor
public class SalaController {

    private SalaService service;

    @GetMapping
    public List<SalaDTO> consultarSalasYCapacidades() {
        return service.consultarSalasYCapacidades();
    }

}