package es.safareyes.cinetown.controladores;

import es.safareyes.cinetown.dtos.CompraDTO;
import es.safareyes.cinetown.dtos.CrearCompraDTO;
import es.safareyes.cinetown.servicios.CompraService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/compras")
@AllArgsConstructor
public class CompraController {

    private final CompraService compraService;


    @PostMapping
    public CompraDTO crearCompra(@Valid @RequestBody CrearCompraDTO dto) {
        return compraService.crearCompra(dto);
    }



    @GetMapping("/{codigo}")
    public CompraDTO obtenerCompraPorCodigo(@PathVariable String codigo) {
        return compraService.consultarCompraPorCodigo(codigo);
    }


    @GetMapping
    public List<CompraDTO> obtenerTodasLasCompras(){
        return compraService.consultarTodasLasCompras();

    }


    @PatchMapping("/{codigo}/cancelar")
    public CompraDTO cancelarCompraPorCodigo(@PathVariable String codigo){
        return compraService.cancelarCompra(codigo);
    }


}
