package ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dto.requets.ErrorResponse;

import dto.response.UsuarioResponse;
import ps.model.Cuenta;
import ps.model.Usuario;
import ps.repository.UsuarioRepository;
import ps.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

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
	public ResponseEntity<Object> obtenerTodosLosUsuarios() {
		try {
			// TODO: Pasar al service.
			UsuarioResponse jr = new UsuarioResponse(usuarioRepository.findAll());
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
	

    // Endpoint para obtener la cuenta de un usuario por su ID
    @GetMapping("/cuenta")
    public Cuenta obtenerCuentaPorUsuario(@PathVariable Long id_usuario) {
        return usuarioService.obtenerCuentaPorUsuario(id_usuario);
    }

    // Endpoint para restar un monto a la cuenta por su ID
    @PutMapping("/{idCuenta}/{monto}")
    public Cuenta restarMontoACuenta(@PathVariable Long id, @PathVariable double saldo) {
        return usuarioService.restarMontoACuenta(id, saldo);
    }

	// Crear un nuevo usuario
	@PostMapping
	public Usuario crearUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
    @GetMapping("/rolAdmin/{id}")
    public boolean xRolAdmin(@PathVariable long id){
        if(usuarioRepository.xRol(id) == 'a'){
           return true;
        }
       return false ;
   } 
  

   @GetMapping("/rolDueño/{id_usuario}")
    public boolean xRolDueño(@PathVariable long id){
        if(usuarioRepository.xRol(id) == 'd'){
           return true;
        }
       return false ;
   } 
   @GetMapping("/rolUsuario/{id_usuario}")
   public boolean xRolUsuario(@PathVariable long id){
       if(usuarioRepository.xRol(id) == 'u'){
          return true;
       }
      return false ;
  } 

	
	// Actualizar un Usuario existente por ID
	@PutMapping("/{id_usuario}")
	public Usuario actualizarUsuario(@PathVariable long id_usuario, @RequestBody Usuario usuarioActualizado) {
		usuarioActualizado.setId_usuario(id_usuario);
		return usuarioRepository.save(usuarioActualizado);
	}

	// Eliminar un Usuario por ID
	@DeleteMapping("/{id_usuario}")
	public void eliminarUsuario(@PathVariable long id_usuario) {
		usuarioRepository.deleteById(id_usuario);
	}

	
}
