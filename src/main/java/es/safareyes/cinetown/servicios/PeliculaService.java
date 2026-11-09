package es.safareyes.cinetown.servicios;

import es.safareyes.cinetown.conversores.PeliculaMapper;
import es.safareyes.cinetown.dtos.PeliculaDTO;
import es.safareyes.cinetown.excepciones.ElementoNoEncontrado;
import es.safareyes.cinetown.modelos.Pelicula;
import es.safareyes.cinetown.repositorios.IPeliculaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PeliculaService {

    private IPeliculaRepository repository;
    private PeliculaMapper mapper;

    public PeliculaDTO consultarPorIdConGeneros(Integer id) {
        return repository.buscarPorIdConGeneros(id).map(mapper::toDTO)
                .orElseThrow(() -> new ElementoNoEncontrado("Pelicula no encontrada"));
    }

    public List<PeliculaDTO> buscarTodasLasPeliculas() {
        return mapper.toDTO(repository.buscarTodasLasPeliculasConGeneros());
    }

}