package Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ps.model.Usuario;
import ps.model.dto.UsuarioDto;
import ps.repository.UsuarioRepository;

@Service
public class DefaultUserServiceImpl implements DefaultUserService {

	@Autowired
	UsuarioRepository usuario_repository;

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = this.usuario_repository.findByEmail(username);

		return new org.springframework.security.core.userdetails.User(usuario.getCorreo(), usuario.getContraseña(),
				mapRolesToAuthorities(usuario.getRol()));
	}

	public Collection<? extends GrantedAuthority> mapRolesToAuthorities(String rol) {
		List<GrantedAuthority> authorities = new ArrayList<>();

		authorities.add(new SimpleGrantedAuthority(rol));
		return authorities;
	}

	@Override
	public Usuario save(UsuarioDto usuario_dto) {
		String role = "USER";
		if (String.valueOf(role).equals("a"))
			role = "ADMIN";

		Usuario usuario = new Usuario();
		usuario.setCorreo(usuario_dto.getCorreo());
		usuario.setContraseña(passwordEncoder.encode(usuario_dto.getContraseña()));
		usuario.setRol(role);

		return this.usuario_repository.save(usuario);
	}
}

