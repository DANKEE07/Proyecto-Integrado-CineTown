package es.safareyes.cinetown.servicios;

import es.safareyes.cinetown.conversores.PeliculaMapper;
import es.safareyes.cinetown.dtos.CrearPeliculaDTO;
import es.safareyes.cinetown.dtos.PeliculaDTO;
import es.safareyes.cinetown.excepciones.ElementoNoEncontrado;
import es.safareyes.cinetown.modelos.Genero;
import es.safareyes.cinetown.modelos.Pelicula;
import es.safareyes.cinetown.repositorios.IGeneroRepository;
import es.safareyes.cinetown.repositorios.IPeliculaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PeliculaService {

    private final IPeliculaRepository peliculaRepository;
    private final PeliculaMapper peliculaMapper;
    private final IGeneroRepository generoRepository;

    public PeliculaDTO consultarPorIdConGeneros(Integer id) {
        return peliculaRepository.buscarPorIdConGeneros(id).map(peliculaMapper::toDTO)
                .orElseThrow(() -> new ElementoNoEncontrado("Pelicula no encontrada"));
    }

    public Page<PeliculaDTO> buscarTodasLasPeliculas(Pageable pageable) {
        return peliculaRepository.findAll(pageable).map(peliculaMapper::toDTO);
    }

    @Transactional
    public PeliculaDTO crearPelicula(CrearPeliculaDTO dto) {

        List<Genero> generos = generoRepository.findAllById(dto.generos());

        if (generos.size() != dto.generos().size())
            throw new ElementoNoEncontrado("Uno o más generos no existen");

        Pelicula pelicula = new Pelicula();

        pelicula.setAnio(dto.anio());
        pelicula.setTitulo(dto.titulo());
        pelicula.setActivo(true);
        pelicula.setClasificacion(dto.clasificacion());
        pelicula.setDuracion(dto.duracion());
        pelicula.setSinopsis(dto.sinopsis());
        pelicula.setGeneros(generos);

        return peliculaMapper.toDTO(peliculaRepository.save(pelicula));
    }

    @Transactional
    public PeliculaDTO modificarPelicula(Integer id, CrearPeliculaDTO dto) {
        Pelicula pelicula = peliculaRepository.findById(id).orElseThrow(() -> new ElementoNoEncontrado("Pelicula no encontrada"));

        List<Genero> generos = generoRepository.findAllById(dto.generos());

        if (generos.size() != dto.generos().size()) {
            throw new ElementoNoEncontrado("Uno o más generos no existen");
        }

        pelicula.setAnio(dto.anio());
        pelicula.setTitulo(dto.titulo());
        pelicula.setClasificacion(dto.clasificacion());
        pelicula.setDuracion(dto.duracion());
        pelicula.setSinopsis(dto.sinopsis());
        pelicula.setGeneros(generos);

        return peliculaMapper.toDTO(peliculaRepository.save(pelicula));
    }

}