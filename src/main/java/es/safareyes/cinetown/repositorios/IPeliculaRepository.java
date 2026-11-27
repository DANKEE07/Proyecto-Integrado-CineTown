package es.safareyes.cinetown.repositorios;

import es.safareyes.cinetown.dtos.PeliculaDTO;
import es.safareyes.cinetown.dtos.RecaudacionDTO;
import es.safareyes.cinetown.modelos.Pelicula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPeliculaRepository extends JpaRepository<Pelicula, Integer> {

    // ******** REPOSITORIES TEST

    @Query("SELECT DISTINCT p FROM Pelicula p LEFT JOIN FETCH p.generos WHERE p.titulo LIKE %:titulo%")
    List<Pelicula> buscarPorTitulo(@Param("titulo") String titulo);



    @Query("SELECT DISTINCT p FROM Pelicula p LEFT JOIN FETCH p.generos WHERE p.id = :id")
    List<Pelicula> buscarPorIdConGenerosParaTest(@Param("id") Integer id);

    // ********



    // Listado paginado con Filtros (Filtro de nombre)
    @Query("SELECT DISTINCT p FROM Pelicula p LEFT JOIN FETCH p.generos")
    List<Pelicula> buscarTodasLasPeliculasConGeneros();



    // Detalle y género de la película
    @Query("SELECT DISTINCT p FROM Pelicula p LEFT JOIN FETCH p.generos WHERE p.id = :id")
    Optional<Pelicula> buscarPorIdConGeneros(@Param("id") Integer id);



    // Filtrado opcional endpoint 1
    @Query("SELECT DISTINCT p FROM Pelicula p " +
            "LEFT JOIN p.generos g " +
            "WHERE (:genero IS NULL OR LOWER(g.nombre) = LOWER(CAST(:genero AS string))) " +
            "AND (:clasificacion IS NULL OR p.clasificacion = :clasificacion) " +
            "AND (:anio IS NULL OR p.anio = :anio) " +
            "AND (:titulo IS NULL OR LOWER(p.titulo) LIKE LOWER(CONCAT('%', CAST(:titulo AS string), '%'))) " +
            "AND (:activo IS NULL OR p.activo = :activo)")
    // Esta query me daba error porque no tenía el CAST puesto, hablando con la IA me ha dicho que si no pongo el CAST
    // no va a tratar el dato como texto, entonces no me va a funcionar correctamente, y también me ha recomendado que ponga el
    // LOWER para que no haya problemas de mayúsculas y minúsculas

    Page<Pelicula> buscarConFiltros(
            @Param("genero") String genero,
            @Param("clasificacion") String clasificacion,
            @Param("titulo") String titulo,
            @Param("activo") Boolean activo,
            @Param("anio") Integer anio,
            Pageable pageable
    );



    // Obtener la recaudación=
    @Query("SELECT new es.safareyes.cinetown.dtos.RecaudacionDTO(SUM(c.numEntradas), " +
            "SUM (c.precioTotal)) FROM Sesion s Join s.compras c WHERE s.pelicula.id = :id AND c.estado = 'CONFIRMADA'")

    RecaudacionDTO obtenerRecaudacion(@Param("id") Integer id);

}
