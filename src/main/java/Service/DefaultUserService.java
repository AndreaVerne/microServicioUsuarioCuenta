package Service;


import org.springframework.security.core.userdetails.UserDetailsService;

import ps.model.Usuario;
import ps.model.dto.UsuarioDto;

public interface DefaultUserService extends UserDetailsService {
	Usuario save(UsuarioDto usuario_dto);
}
