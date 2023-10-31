package ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dto.requets.ErrorResponse;
import dto.response.CuentaResponse;

import ps.model.Cuenta;
import ps.model.Usuario;
import ps.repository.CuentaRepository;
import ps.repository.UsuarioRepository;
import ps.controller.UsuarioController;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

	
	@Autowired
	private CuentaRepository cuentaRepository;

	@Value("${variable_env}")
	private String variable_env;

	@GetMapping("/variable_env")
	public String obtener_variable_env() {
		return variable_env;
	}

	@GetMapping("/string")
	public String obtener_string_hardcodeado() {
		return "Un mensaje de texto.";
	}

	// Obtener todos los usuario
	@GetMapping
	public ResponseEntity<Object> obtenerTodosLasCuentas() {
		try {
			// TODO: Pasar al service.
			CuentaResponse jr = new CuentaResponse(cuentaRepository.findAll());
			// Algun llamado al service.
			//throw new Exception("Este es un mensaje opcional");
			return ResponseEntity.ok(jr);
			
		} catch (Exception e) {
			// Ojo con esto por que puede enviar un error de BD al front,
			// se deberia controlar con e custom o error generico.
			ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
		}
	}

	// Crear un nuevo Cuenta
	@PostMapping
	public Cuenta crearCuenta(@RequestBody Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}
	//@PutMapping("/agregarUsuario/{id_usuario")
	//public Cuenta agregarUsuario(@PathVariable long id_usuario ,  @RequestBody Cuenta cuenta) {

		//	if(UsuarioController.xRolAdmin(id_usuario)) {
				
		//	}
	
	//}

	@DeleteMapping("/{id}")
	public void deshabilitarCuenta(@PathVariable long id) {
		cuentaRepository.deleteById(id);
	}
	
	

	// Actualizar un Cuenta existente por ID
	@PutMapping("/{id}")
	public Cuenta actualizarCuenta(@PathVariable long id, @RequestBody Cuenta cuentaActualizado) {
		cuentaActualizado.setId(id);
		return cuentaRepository.save(cuentaActualizado);
	}

	// Eliminar un Cuenta por ID
	@DeleteMapping("/{id}")
	public void eliminarCuenta(@PathVariable long id) {
		cuentaRepository.deleteById(id);
	}

	
}


