package ps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dto.requets.ErrorResponse;
import dto.response.CuentaResponse;
import io.swagger.v3.oas.annotations.Operation;
import ps.model.Cuenta;
import ps.repository.CuentaRepository;

import ps.servicios.CuentaService;
import ps.servicios.UsuarioService;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

	
	@Autowired
	private CuentaRepository cuentaRepository;

	  @Autowired
	  private CuentaService cuentaService;
	 
	  @Autowired
	  private UsuarioService usuarioService;
	  
	  @Autowired
	  private CuentaResponse cuentaResponse;
	  
	  
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
	   try {
			// si el token es valido
			if (token.autorizado(authorization) == null){
           	return null;
			}else{
				CuentaResponse p = new CuentaResponse(CuentaRepository.findAll());
				return ResponseEntity.ok(p);
			}
		} catch (Exception e) {
			// Ojo con esto por que puede enviar un error de BD al front,
			// se deberia controlar con e custom o error generico.
			ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
		}
		
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
    @Operation(summary = "elininar cuenta", description = "")
	public void eliminarCuenta(@PathVariable long id) {
		cuentaRepository.deleteById(id);
	}

	
}


