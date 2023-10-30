package ps.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dto.requets.ErrorResponse;
import dto.response.JugadorResponse;
import ps.model.Jugador;
import ps.repository.JugadorRepository;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {
	
	@Autowired
	private JugadorRepository jugadorRepository;

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

	// Obtener todos los jugadores
	@GetMapping
	public ResponseEntity<Object> obtenerTodosLosJugadores() {
		try {
			// TODO: Pasar al service.
			JugadorResponse jr = new JugadorResponse(jugadorRepository.findAll());
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

	// Crear un nuevo jugador
	@PostMapping
	public Jugador crearJugador(@RequestBody Jugador jugador) {
		return jugadorRepository.save(jugador);
	}

	// Actualizar un jugador existente por ID
	@PutMapping("/{id}")
	public Jugador actualizarJugador(@PathVariable ObjectId id, @RequestBody Jugador jugadorActualizado) {
		jugadorActualizado.setId(id);
		return jugadorRepository.save(jugadorActualizado);
	}

	// Eliminar un jugador por ID
	@DeleteMapping("/{id}")
	public void eliminarJugador(@PathVariable ObjectId id) {
		jugadorRepository.deleteById(id);
	}

	
}
