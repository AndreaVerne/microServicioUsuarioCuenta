package ps.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ps.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	//ver consulta.. es de tipo char pero devuelvo un id ¿?
	  @Query("SELECT u.rol FROM Usuario u WHERE  id_usuario = :id_usuario")
		public char xRol(long id_usuario);


	    Optional<Usuario> findByNombre(String nombre);
	    Usuario findByEmail(String correo);

}