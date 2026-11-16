package es.safareyes.cinetown.controladores;

import es.safareyes.cinetown.dtos.CompraDTO;
import es.safareyes.cinetown.dtos.CrearCompraDTO;
import es.safareyes.cinetown.servicios.CompraService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/compras")
@AllArgsConstructor
public class CompraController {

    private final CompraService compraService;


    @PostMapping
    public CompraDTO crearCompra(@Valid @RequestBody CrearCompraDTO dto) {
        return compraService.crearCompra(dto);
    }


}
