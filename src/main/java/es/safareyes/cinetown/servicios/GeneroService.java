package es.safareyes.cinetown.servicios;

import es.safareyes.cinetown.dtos.GeneroCarteleraDTO;
import es.safareyes.cinetown.repositorios.IGeneroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class GeneroService {

    private IGeneroRepository generoRepository;

    // Consultar géneros con el número de películas en cartelera
    public List<GeneroCarteleraDTO> consultarGenerosConPeliculasEnCartelera() {

        return generoRepository.contarGenerosConPeliculasEnCartelera()
                .stream()
                .map(genero -> new GeneroCarteleraDTO(
                        genero.getId(),
                        genero.getNombre(),
                        genero.getNumeroPeliculasEnCartelera()
                ))
                .collect(Collectors.toList());

    }

}