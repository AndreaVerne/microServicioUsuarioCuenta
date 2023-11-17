package ps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;

import JWT.JWTService;

import io.swagger.v3.oas.annotations.Operation;
import ps.model.Cuenta;
import ps.model.Usuario;
import ps.repository.UsuarioRepository;
import ps.servicios.CuentaService;
import ps.servicios.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
    @Autowired
    private CuentaService cuentaServicio;

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	  @Autowired
	    private JWTService jwtService;

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

	 @GetMapping("/verificarToken/{token}")
	    @Operation(summary = "Verificar token", description = "Le llega un token en forma de string y si es valido devuelve el rol del usuario")
	    public String verificarToken(@PathVariable String token) {
	        return jwtService.verificarToken(token);
	    }
	// Obtener todos los usuario
	   @GetMapping
	    @Operation(summary = "Lista usuarios", description = "FindAll de los usuarios en el repositorio")
	    public List<Usuario> listarUsuarios() {
	        return usuarioRepository.findAll();
	    }

    // Endpoint para obtener la cuenta de un usuario por su ID
    @GetMapping("/cuenta")
    public Cuenta obtenerCuentaPorUsuario(@PathVariable Long id_usuario) {
        return usuarioService.obtenerCuentaPorUsuario(id_usuario);
    }

    // Endpoint para restar un monto a la cuenta por su ID//ver
    @PutMapping("/{id}/{monto}")
    @Operation(summary = "", description = "")
    public Cuenta restarMontoACuenta(@PathVariable Long id, @PathVariable double saldo) {
        return usuarioService.restarMontoACuenta(id, saldo);
    }

	// Crear un nuevo usuario
	@PostMapping
	 @Operation(summary = "Crear usuario", description = "Recibe un usuario por el body y lo guarda en el repositorio")
	public Usuario crearUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
   
	
    @GetMapping("/rolAdmin/{id_usuario}")
    public boolean xRolAdmin(@PathVariable long id_usuario){
        if(usuarioRepository.xRol(id_usuario) == 'a'){
           return true;
        }
       return false ;
   } 
  
   @GetMapping("/rolDueño/{id_usuario}")
    public boolean xRolDueño(@PathVariable long id_usuario){
        if(usuarioRepository.xRol(id_usuario) == 'd'){
           return true;
        }
       return false ;
   } 
   @GetMapping("/rolUsuario/{id_usuario}")
   public boolean xRolUsuario(@PathVariable long id_usuario){
       if(usuarioRepository.xRol(id_usuario) == 'u'){
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

	   @GetMapping("/anularCuenta/{id}")
	    @Operation(summary = "Anula/Deshabilita cuenta", description = "Confirma si el token del solicitante es de un admin y deshabilita la cuenta")
	    public String anularCuenta(@RequestHeader("Authorization") String authorization, @PathVariable Long id) {

	        // Busca usuario y comprueba si es administrador
	        if (esAdmin(authorization)) {
	            String intentarAnularCuenta = cuentaServicio.anularCuenta(id);
	            return intentarAnularCuenta;
	        }
	        return "Necesitas permisos de administrador.";
	    }
	   private boolean esAdmin(String authorization) {
	        String tokenSinBearer = authorization.substring(7);
	        if (jwtService.isAdmin(tokenSinBearer))
	            return true;
	        return false;
	    }
	}