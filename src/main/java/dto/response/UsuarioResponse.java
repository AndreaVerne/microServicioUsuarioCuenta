package dto.response;

import java.util.List;


import ps.model.Usuario;

public class UsuarioResponse {

	private List<Usuario> usuarios;

	public UsuarioResponse(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
