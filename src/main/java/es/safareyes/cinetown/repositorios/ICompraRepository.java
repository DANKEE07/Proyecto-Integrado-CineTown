package es.safareyes.cinetown.repositorios;

import es.safareyes.cinetown.modelos.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICompraRepository extends JpaRepository<Compra, Integer> {

    boolean existsByCodigo(String codigo);


    Optional<Compra> findByCodigo(String codigo);


}
