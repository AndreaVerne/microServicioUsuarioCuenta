package ps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;


import io.swagger.v3.oas.annotations.Operation;

import ps.model.Cuenta;
import ps.repository.CuentaRepository;
import ps.service.TokenServicio;
import ps.servicios.CuentaService;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

	
	@Autowired
	private CuentaRepository cuentaRepository;

	  @Autowired
	  private CuentaService cuentaService;

	  @Autowired
	  private TokenServicio	 token;
	  
	  
	  
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


	 @GetMapping
	    @Operation(summary = "Lista cuentas", description = "FindAll de las cuentas en el repositorio")
	    public List<Cuenta> dameCuentas(@RequestHeader("Authorization") String authorization) {
	        return cuentaRepository.findAll();
	    }

    @PostMapping("/crearCuenta")
    @Operation(summary = "crear cuenta", description = "")
    public String crearCuenta(@RequestParam Long id, @RequestBody Cuenta cuenta,  @RequestHeader("Authorization") String authorization) {
    	if (token.autorizado(authorization).contains("a")) {
        cuentaService.crearCuenta(id, cuenta);
        return "La cuenta fue creada con exito";
    	}
    	  return "La cuenta  no se ha podido crear, verifique los datos";
    }
    @PutMapping("/agregarUsuario/{id}")
    @Operation(summary = "agregar usuario", description = "")
    public String agregarUsuario(@PathVariable Long id, @RequestParam Long idUsuarioSolicitante, @RequestParam Long idUsuarioAgregado, @RequestHeader("Authorization") String authorization) {
    	if (token.autorizado(authorization).contains("a")) {
    		 cuentaService.agregarUsuario(id, idUsuarioSolicitante, idUsuarioAgregado);
    		  return "Usuario agregado con exito";
    	}
    	  return "El usuario no se ha podido agregar, verifique los datos";
    }

	// Actualizar un Cuenta existente por ID
	@PutMapping("/{id}")
    @Operation(summary = "actualizar cuenta", description = "")
	public String actualizarCuenta(@PathVariable long id, @RequestBody Cuenta cuentaActualizado, @RequestHeader("Authorization") String authorization) {
		if (token.autorizado(authorization).contains("a")) {
			cuentaActualizado.setId(id);
			  cuentaRepository.save(cuentaActualizado);
			  return "Cuenta actualizada con exito";
		}
		return "No se encontro una cuenta con ese id";
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
	public void eliminarCuenta(@PathVariable long id , @RequestHeader("Authorization") String authorization) {
		if (token.autorizado(authorization).contains("a")) {
             cuentaRepository.deleteById(id);;
        }

	}

	
}


