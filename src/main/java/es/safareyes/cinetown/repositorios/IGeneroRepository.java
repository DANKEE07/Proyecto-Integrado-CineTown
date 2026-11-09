package es.safareyes.cinetown.repositorios;

import es.safareyes.cinetown.modelos.Genero;
import es.safareyes.cinetown.proyecciones.GeneroCarteleraProyeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IGeneroRepository extends JpaRepository<Genero, Integer> {

    @Query(value = "SELECT g.id AS id, g.nombre AS nombre, COUNT(DISTINCT p.id) AS \"numeroPeliculasEnCartelera\" " +
            "FROM genero g LEFT JOIN pelicula_genero pg ON g.id = pg.id_genero " +
            "LEFT JOIN pelicula p ON pg.id_pelicula = p.id AND p.activo = true " +
            "GROUP BY g.id, g.nombre", nativeQuery = true)
    List<GeneroCarteleraProyeccion> contarGenerosConPeliculasEnCartelera();
}
