package es.safareyes.cinetown.repositorios;

import es.safareyes.cinetown.modelos.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalaRepository extends JpaRepository<Sala, Integer> {
}
