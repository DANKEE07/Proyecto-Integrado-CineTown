package es.safareyes.cinetown.servicios;

import es.safareyes.cinetown.conversores.GeneroMapper;
import es.safareyes.cinetown.dtos.GeneroCarteleraDTO;
import es.safareyes.cinetown.dtos.GeneroDTO;
import es.safareyes.cinetown.excepciones.ElementoNoEncontrado;
import es.safareyes.cinetown.modelos.Genero;
import es.safareyes.cinetown.repositorios.IGeneroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class GeneroService {

    private IGeneroRepository repository;

    // Consultar géneros con el número de películas en cartelera
    public List<GeneroCarteleraDTO> consultarGenerosConPeliculasEnCartelera() {

        return repository.contarGenerosConPeliculasEnCartelera()
                .stream()
                .map(genero -> new GeneroCarteleraDTO(
                        genero.getId(),
                        genero.getNombre(),
                        genero.getNumeroPeliculasEnCartelera()
                ))
                .collect(Collectors.toList());

    }

}