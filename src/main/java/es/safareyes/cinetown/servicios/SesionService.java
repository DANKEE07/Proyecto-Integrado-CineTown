package es.safareyes.cinetown.servicios;

import es.safareyes.cinetown.conversores.SesionMapper;
import es.safareyes.cinetown.dtos.CrearSesionDTO;
import es.safareyes.cinetown.dtos.OcupacionDTO;
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
import tools.jackson.databind.cfg.MapperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SesionService {

    private final ISesionRepository sesionRepository;
    private final ISalaRepository salaRepository;
    private final IPeliculaRepository peliculaRepository;
    private final SesionMapper sesionMapper;
    private final MapperBuilder mapperBuilder;


    public SesionDTO crearSesion(CrearSesionDTO dto) {

        Pelicula pelicula = peliculaRepository.findById(dto.idPelicula())
                .orElseThrow(() -> new ElementoNoEncontrado("Película no encontrada"));

        Sala sala = salaRepository.findById(dto.idSala())
                .orElseThrow(() -> new ElementoNoEncontrado("Sala no encontrada"));


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



    public List<SesionDTO> buscarSesionesConPeliculaYAsientos(LocalDate fecha, Integer peliculaId) {
        List<Sesion> sesiones = sesionRepository.buscarSesiones(fecha, peliculaId);

        return sesionMapper.sesionesToSesionDTOs(sesiones);
    }



    public SesionDTO consultarSesionPorId(Integer sesionId) {
        Sesion sesion = sesionRepository.findById(sesionId)
                .orElseThrow(() -> new ElementoNoEncontrado("Sala no encontrada"));

        return sesionMapper.sesionToSesionDTO(sesion);
    }



    public List<OcupacionDTO> consultarOcupacionPorSesion(LocalDate fecha) {

        List<Object[]> ocupaciones = sesionRepository.obtenerOcupacion(fecha);

        return ocupaciones.stream().map(fila -> new OcupacionDTO(
                (Integer) fila[0],
                (String) fila[1],
                (Integer) fila[2],
                ((Number) fila[3]).longValue(),
                ((Number) fila[4]).doubleValue())).toList();

        // Esta parte me ha costado, porque como he decidido usar un array de objetos
        // tenía que mapear cada fila a un objeto (Por ejemplo, la fila[0] sería el id, este
        // se encargaría de mappear el id ya que es el primero de OcupacionDTO el segundo sería
        // el nombre de la pelicula, ya que al igual que el anterior es el que tengo en el DTO
        // (por eso el segundo es un String, porque es el título), y al final con el .stream()
        // lo que hago es recorrer los elementos, así cada fila me da un objeto el cual puedo usar y modificar
        // con el .map() Después simplemente le pongo el .toList() para volver a pasarlo a una lista

        // (me ha faltado llorar haciendo esto Luis)
    }


}
