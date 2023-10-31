package ps.repository;


import dto.response.CuentaResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ps.model.Cuenta;


@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {



}
