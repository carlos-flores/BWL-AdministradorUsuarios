package mx.com.bwl.service;

import java.util.List;

import mx.com.bwl.model.Usuario;

public interface IUsuariosService {
	List<Usuario> getAll();
	Usuario get(int id);
	Usuario getPorUsername(String username);
	Usuario save(Usuario usuario);
	Usuario update(Usuario usuario);
	void delete(int idUsuario);
}
