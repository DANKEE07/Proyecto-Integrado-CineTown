package es.safareyes.cinetown.servicios;

import es.safareyes.cinetown.conversores.CompraMapper;
import es.safareyes.cinetown.dtos.CompraDTO;
import es.safareyes.cinetown.dtos.CrearCompraDTO;
import es.safareyes.cinetown.excepciones.ElementoNoEncontrado;
import es.safareyes.cinetown.excepciones.FechaYHoraPosteriorActual;
import es.safareyes.cinetown.excepciones.NoHaySuficientesPlazas;
import es.safareyes.cinetown.modelos.Compra;
import es.safareyes.cinetown.modelos.Sesion;
import es.safareyes.cinetown.modelos.Usuario;
import es.safareyes.cinetown.repositorios.ICompraRepository;
import es.safareyes.cinetown.repositorios.ISesionRepository;
import es.safareyes.cinetown.repositorios.IUsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor

public class CompraService {

    private final ICompraRepository compraRepository; // Guarda la Compra
    private final ISesionRepository sesionRepository; // Busca la Sesión y descuenta las plazas
    private final IUsuarioRepository usuarioRepository; // Busca al usuario
    private final CompraMapper compraMapper; // Convierte la compra en el DTO


    @Transactional
    public CompraDTO crearCompra(CrearCompraDTO dto) {




        Sesion sesion = sesionRepository.findById(dto.idSesion())
                .orElseThrow(() -> new ElementoNoEncontrado("No se encontró la sesión"));


        Usuario usuario = usuarioRepository.findById(dto.idUsuario())
                .orElseThrow(() -> new ElementoNoEncontrado("No existe el usuario"));


        if (!sesion.getFechaHoraInicio().isAfter(LocalDateTime.now())) {
            throw new FechaYHoraPosteriorActual("La sesión ya ha comenzado");
        }




        int plazasActualizadas = sesionRepository.descontarPlazas(sesion.getId(), dto.numEntradas());


        if (plazasActualizadas == 0) {
            throw new NoHaySuficientesPlazas("No hay suficientes plazas disponibles");
        }




        float precioUnitario = sesion.getPrecioBase();

        if (sesion.getFechaHoraInicio().getDayOfWeek() == DayOfWeek.WEDNESDAY) {
            precioUnitario = precioUnitario * 0.70f;
        }


        float precioTotal = precioUnitario * dto.numEntradas();


        String codigo = generarCodigoUnico();




        Compra compra = new Compra();

        compra.setCodigo(codigo);
        compra.setParkingUsado(false);
        compra.setFechaCompra(LocalDateTime.now());
        compra.setNumEntradas(dto.numEntradas());
        compra.setEmail(dto.email());
        compra.setPrecioTotal(precioTotal);
        compra.setEstado("CONFIRMADA");
        compra.setSesion(sesion);
        compra.setUsuario(usuario);



        Compra compraGuardada = compraRepository.save(compra);

        return compraMapper.toDTO(compraGuardada);

    }




    private String generarCodigo() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 8).toUpperCase();
    }




    private String generarCodigoUnico() {
        String codigo;

        do {
            codigo = generarCodigo();
        } while (compraRepository.existsByCodigo(codigo));

        return codigo;
    }


}
