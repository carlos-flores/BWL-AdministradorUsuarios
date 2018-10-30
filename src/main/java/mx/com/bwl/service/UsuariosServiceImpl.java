package mx.com.bwl.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.bwl.model.Usuario;
import mx.com.bwl.repository.UsuariosRepository;

@Service
public class UsuariosServiceImpl implements IUsuariosService{
	
	@Autowired
	private UsuariosRepository usuariosREPO;
	
	public UsuariosServiceImpl() {
		super();
	}

	@Override
	public List<Usuario> getAll() {
		return usuariosREPO.findAll();
	}

	@Override
	public Usuario get(int id) {
		if(usuariosREPO.existsById(id)) {
			return usuariosREPO.findById(id).get();
		}
		return null;
	}
	
	public Usuario getPorUsername(String username) {
		List<Usuario> usuarios = usuariosREPO.findByUsername(username); 
		if(usuarios!=null && !usuarios.isEmpty() ) {
			return usuarios.get(0);
		}
		return null;
	}

	@Override
	public Usuario save(Usuario usuario) {
		usuario.setStatus(1);
		usuario.setPwd("{noop}"+usuario.getPwd());
		return usuariosREPO.save(usuario);
//		Role roleTemp;
//		List<Role> listRoles = rolesREPO.findByUsername(usuario.getUsername());
//		if(listRoles!=null && !listRoles.isEmpty()) {
//			roleTemp = listRoles.get(0);
//		}else {
//			roleTemp = new Role(0,usuario.getUsername(),role); 
//		}
//		rolesREPO.save(roleTemp);
//		return usuario;
	}

	@Override
	public Usuario update(Usuario usuario) {
		usuario.setPwd("{noop}"+usuario.getPwd());
		usuario.setFechaactualizacion(new Timestamp(System.currentTimeMillis()));
		return usuariosREPO.save(usuario);
	}

	@Override
	public void delete(int idUsuario) {
		usuariosREPO.deleteById(idUsuario);
	}

}
