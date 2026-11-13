package es.safareyes.cinetown.servicios;

import es.safareyes.cinetown.conversores.SesionMapper;
import es.safareyes.cinetown.dtos.CrearSesionDTO;
import es.safareyes.cinetown.dtos.SesionDTO;
import es.safareyes.cinetown.excepciones.ElementoNoEncontrado;
import es.safareyes.cinetown.excepciones.SesionConFechaHoraInicioPasada;
import es.safareyes.cinetown.excepciones.SesionConPeliculaInactiva;
import es.safareyes.cinetown.excepciones.SesionSolapada;
import es.safareyes.cinetown.modelos.Pelicula;
import es.safareyes.cinetown.modelos.Sala;
import es.safareyes.cinetown.modelos.Sesion;
import es.safareyes.cinetown.repositorios.IPeliculaRepository;
import es.safareyes.cinetown.repositorios.ISalaRepository;
import es.safareyes.cinetown.repositorios.ISesionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class SesionService {

    private final ISesionRepository sesionRepository;
    private final ISalaRepository salaRepository;
    private final IPeliculaRepository peliculaRepository;
    private final SesionMapper sesionMapper;

    public SesionDTO crearSesion(CrearSesionDTO dto) {

        Pelicula pelicula = peliculaRepository.findById(dto.idPelicula()).orElseThrow(() -> new ElementoNoEncontrado("Película no encontrada"));

        Sala sala = salaRepository.findById(dto.idSala()).orElseThrow(() -> new ElementoNoEncontrado("Sala no encontrada"));

        if (!pelicula.getActivo())
            throw new SesionConPeliculaInactiva("No se puede crear una sesión de una película que no está activa");

        // Si la fechaHoraInicio no es después de ahora ni ahora, deduce que es anterior (pasada), y da el error
        if (!dto.fechaHoraInicio().isAfter(LocalDateTime.now()))
            throw new SesionConFechaHoraInicioPasada("No se puede crear una sesión con fecha y hora de inicio pasada");

        // Para que sume a FechaHoraInicio la duración de la película (minutos) y lo guarde en esta variable
        LocalDateTime fechaHoraFin = dto.fechaHoraInicio().plusMinutes(pelicula.getDuracion());

        // Para que dé un error si ya hay otra pelicula en ese horario
        boolean existeSolapamiento = sesionRepository.existsBySalaIdAndFechaHoraInicioLessThanAndFechaHoraFinGreaterThan(sala.getId(), fechaHoraFin.plusMinutes(20), dto.fechaHoraInicio().minusMinutes(20));

        if (existeSolapamiento)
            throw new SesionSolapada("Ya existe una sesión en esa sala durante ese horario");

        Sesion sesion = new Sesion();
        sesion.setPrecioBase(dto.precioBase());
        sesion.setFechaHoraInicio(dto.fechaHoraInicio());
        sesion.setFechaHoraFin(fechaHoraFin);
        sesion.setSala(sala);
        sesion.setPelicula(pelicula);
        sesion.setPlazasDisponibles(sala.getCapacidad());

        return sesionMapper.sesionToSesionDTO(sesionRepository.save(sesion));

    }

}
