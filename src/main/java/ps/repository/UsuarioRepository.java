package ps.repository;

import dto.response.UsuarioResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import ps.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


	  @Query("SELECT u.rol FROM Usuario u WHERE  id_usuario = :id_usuario")
		public char xRol(long id_usuario);

	

}
