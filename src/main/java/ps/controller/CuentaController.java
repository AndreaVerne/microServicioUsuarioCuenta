package ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;


import io.swagger.v3.oas.annotations.Operation;
import ps.model.Cuenta;
import ps.repository.CuentaRepository;

import ps.servicios.CuentaService;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

	
	@Autowired
	private CuentaRepository cuentaRepository;

	  @Autowired
	  private CuentaService cuentaService;
	
	  
	  
	  
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


	// Crear un nuevo Cuenta
	@PostMapping
	 @Operation(summary = "Lista cuentas", description = "")
	public Cuenta crearCuenta(@RequestBody Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}

    @PostMapping("/crearCuenta")
    @Operation(summary = "crear cuenta", description = "")
    public Cuenta crearCuenta(@RequestParam Long id, @RequestBody Cuenta cuenta) {
        return cuentaService.crearCuenta(id, cuenta);
    }

    @PutMapping("/agregarUsuario/{id}")
    @Operation(summary = "agregar usuario", description = "")
    public Cuenta agregarUsuario(@PathVariable Long id, @RequestParam Long idUsuarioSolicitante, @RequestParam Long idUsuarioAgregado) {
        return cuentaService.agregarUsuario(id, idUsuarioSolicitante, idUsuarioAgregado);
    }

	// Actualizar un Cuenta existente por ID
	@PutMapping("/{id}")
    @Operation(summary = "actualizar cuenta", description = "")
	public Cuenta actualizarCuenta(@PathVariable long id, @RequestBody Cuenta cuentaActualizado) {
		cuentaActualizado.setId(id);
		return cuentaRepository.save(cuentaActualizado);
	}
	
    // Endpoint para deshabilitar una cuenta por su ID
    @PutMapping("/anularCuenta/{id}")
    @Operation(summary = "Deshabilitar cuenta", description = "Busca cuenta por id y la deshabilita (solo admins)")
    public String deshabilitarCuenta(@PathVariable Long id) {
        Cuenta cuenta = cuentaRepository.findById(id).orElse(null);
        if (cuenta!=null) {
            cuenta.setHabilitada(false);
            cuentaRepository.save(cuenta);
            return "Cuenta deshabilitada con exito";
        }
        return "No se encontro una cuenta con ese id";
    }

	// Eliminar un Cuenta por ID
	@DeleteMapping("/{id}")
    @Operation(summary = "eliminar cuenta", description = "")
	public void eliminarCuenta(@PathVariable long id) {
		cuentaRepository.deleteById(id);
	}

	
}


