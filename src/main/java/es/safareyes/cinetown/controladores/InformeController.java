package es.safareyes.cinetown.controladores;


import es.safareyes.cinetown.dtos.OcupacionDTO;
import es.safareyes.cinetown.servicios.SesionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/informes")
@AllArgsConstructor
public class InformeController {

    // Lo iba a hacer en el SesionController pero como en el GET pides que sea en /api/v1/informes
    // he creado este nuevo controller, para tenerlo más ordenado


    private final SesionService sesionService;

    @GetMapping("/ocupacion")
    public List<OcupacionDTO> consultarOcupacion(@RequestParam LocalDate fecha) {
        return sesionService.consultarOcupacionPorSesion(fecha);
    }

}
