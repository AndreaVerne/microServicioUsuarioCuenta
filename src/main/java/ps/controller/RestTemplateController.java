package ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ps.model.Cuenta;
import ps.model.Usuario;
import ps.service.ApiService;

@RestController
@RequestMapping("/rest_template")
public class RestTemplateController {

	@Autowired
	private ApiService api_service;

	@GetMapping
	public ResponseEntity<String> get() {
		return this.api_service.get();
	}

	@PostMapping
	public ResponseEntity<Usuario> post(@RequestBody Usuario usuario) {
		return this.api_service.post(usuario);
	
	}
	@PostMapping
	public ResponseEntity<Cuenta> post(@RequestBody Cuenta cuenta) {
			return this.api_service.post(cuenta);
		}
	

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.api_service.delete(id);
	}
}
