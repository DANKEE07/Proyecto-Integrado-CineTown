package es.safareyes.cinetown.repositorios;

import es.safareyes.cinetown.dtos.PeliculaDTO;
import es.safareyes.cinetown.modelos.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IPeliculaRepository extends JpaRepository<Pelicula, Integer> {

    // Listado paginado con Filtros (Filtro de nombre)
    @Query(value = "SELECT p FROM Pelicula p WHERE p.titulo LIKE :titulo")
    List<Pelicula> buscarPorTitulo(@Param("titulo") String titulo);

    // Detalle y género de la película
    @Query("SELECT DISTINCT p FROM Pelicula p LEFT JOIN FETCH p.generos WHERE p.id = :id")
    Optional<Pelicula> buscarPorIdConGeneros(@Param("id") Integer id);

}
