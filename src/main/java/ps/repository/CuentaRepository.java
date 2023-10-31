package ps.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ps.model.Cuenta;


@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

	Cuenta findByIdPropietario(Long id_usuario);


	
	  
  
}
