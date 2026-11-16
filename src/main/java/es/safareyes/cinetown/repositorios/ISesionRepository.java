package es.safareyes.cinetown.repositorios;

import es.safareyes.cinetown.modelos.Sesion;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ISesionRepository extends JpaRepository<Sesion, Integer> {



    boolean existsBySalaIdAndFechaHoraInicioLessThanAndFechaHoraFinGreaterThan(Integer salaId, LocalDateTime fechaHoraInicioConLimpieza,
                                                                               LocalDateTime fechaHoraFinConLimpieza);



    @Query(value = "    SELECT s.* FROM sesion s\n" +
            "    WHERE (CAST(:fecha AS DATE) IS NULL OR CAST(s.fecha_hora_inicio AS DATE) = CAST(:fecha AS DATE))\n" +
            "      AND (CAST(:peliculaId AS INTEGER) IS NULL OR s.id_pelicula = CAST(:peliculaId AS INTEGER))", nativeQuery = true)
    List<Sesion> buscarSesiones(
            @Param("fecha") LocalDate fecha,
            @Param("peliculaId") Integer peliculaId
    );



    @Modifying
    @Transactional
    @Query(value = "UPDATE sesion SET plazas_disponibles = plazas_disponibles - :cantidad " +
            "WHERE id = :idSesion AND plazas_disponibles >= :cantidad", nativeQuery = true)

    int descontarPlazas(@Param("idSesion") Integer idSesion,
                        @Param("cantidad") Integer cantidad);


}