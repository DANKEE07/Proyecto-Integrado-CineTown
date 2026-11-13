package es.safareyes.cinetown.repositorios;

import es.safareyes.cinetown.dtos.PeliculaDTO;
import es.safareyes.cinetown.modelos.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPeliculaRepository extends JpaRepository<Pelicula, Integer> {

    // Listado paginado con Filtros (Filtro de nombre)
    @Query("SELECT DISTINCT p FROM Pelicula p LEFT JOIN FETCH p.generos")
    List<Pelicula> buscarTodasLasPeliculasConGeneros();

    // Detalle y género de la película
    @Query("SELECT DISTINCT p FROM Pelicula p LEFT JOIN FETCH p.generos WHERE p.id = :id")
    Optional<Pelicula> buscarPorIdConGeneros(@Param("id") Integer id);

}
