package es.safareyes.cinetown.repositorios;

import es.safareyes.cinetown.modelos.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraRepository extends JpaRepository<Compra, Integer> {
}
