package ps.service;

import org.springframework.beans.factory.annotation.Autowired;

import ps.model.Cuenta;
import ps.repository.CuentaRepository;


public class UsuarioService {
	

	    @Autowired
	    private CuentaRepository cuentaRepository;

	    // Método para obtener la cuenta de un usuario por su ID
	    public Cuenta obtenerCuentaPorUsuario(Long id_usuario) {
	        return cuentaRepository.findByIdPropietario(id_usuario);
	    }

	    // Método para restar un monto de una cuenta
	    public Cuenta restarMontoACuenta(Long id, double saldo) {
	        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
	        cuenta.setSaldo(cuenta.getSaldo() - saldo);
	        return cuentaRepository.save(cuenta);
	    }

	    // Método para deshabilitar una cuenta por su ID
	    public void deshabilitarCuenta(Long id) {
	        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
	        cuenta.setHabilitada(false);
	        cuentaRepository.save(cuenta);
	    }
}
