package es.safareyes.cinetown.repositorios;

import es.safareyes.cinetown.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

}
