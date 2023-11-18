package ps.servicios;

import org.springframework.beans.factory.annotation.Autowired;

import ps.controller.CuentaController;
import ps.model.Cuenta;
import ps.model.Usuario;
import ps.model.dto.CuentaDto;
import ps.repository.CuentaRepository;
import ps.repository.UsuarioRepository;

public class CuentaService {
	@Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CuentaRepository cuentaRepository;
    
    @Autowired
    private CuentaController cuentaController; 
    
    public String anularCuenta(Long id) {
        return cuentaController.deshabilitarCuenta(id);
    }


    // Método para crear una cuenta con un propietario específico
    public Cuenta crearCuenta(Long id_usuario, Cuenta cuenta) {
        Usuario propietario = usuarioRepository.findById(id_usuario).orElseThrow(() -> new RuntimeException("Propietario no encontrado"));
        cuenta.setIdPropietario(propietario);
        return cuentaRepository.save(cuenta);
    }

    // Método para agregar un usuario a una cuenta si el solicitante es el propietario de la cuenta
    public Cuenta agregarUsuario(Long id, Long idUsuarioSolicitante, Long idUsuarioAgregado) {
        Usuario solicitante = usuarioRepository.findById(idUsuarioSolicitante).orElseThrow(() -> new RuntimeException("Usuario solicitante no encontrado"));
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        if (!cuenta.getIdPropietario().equals(solicitante)) {
            throw new RuntimeException("No tienes permiso para realizar esta acción.");
        }

        Usuario usuarioAgregado = usuarioRepository.findById(idUsuarioAgregado).orElseThrow(() -> new RuntimeException("Usuario a agregar no encontrado"));
        cuenta.getUsuarios().add(usuarioAgregado);
        return cuentaRepository.save(cuenta);
    }
    
    
    public Cuenta guardarCuenta(CuentaDto cuentaDto) {
    	Cuenta cuenta = new Cuenta(
    			cuentaDto.getSaldo(),
    			cuentaDto.getId(),
    			cuentaDto.getFecha_creacion());
		
        return cuentaRepository.save(cuenta);
    }


}
