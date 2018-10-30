package mx.com.bwl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.bwl.model.Usuario;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer>{
	List<Usuario> findByUsername(String username);
}
