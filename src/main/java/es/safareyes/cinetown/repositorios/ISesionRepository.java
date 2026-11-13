package es.safareyes.cinetown.repositorios;

import es.safareyes.cinetown.modelos.Sala;
import es.safareyes.cinetown.modelos.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ISesionRepository extends JpaRepository<Sesion, Integer> {

    boolean existsBySalaIdAndFechaHoraInicioLessThanAndFechaHoraFinGreaterThan(Integer salaId, LocalDateTime fechaHoraInicioConLimpieza, LocalDateTime fechaHoraFinConLimpieza);

}
