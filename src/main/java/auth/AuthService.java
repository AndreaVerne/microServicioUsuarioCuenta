package auth;

import ps.model.Usuario;
import ps.repository.UsuarioRepository;
import ps.servicios.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import JWT.JWTService;

@Service
@RequiredArgsConstructor
public class AuthService {
	

    private final PasswordEncoder passwordEncoder ;

    @Autowired
    private UsuarioService userService;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByNombre(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder().token(token).build();
    }

    public AuthResponse register(RegisterRequest request) {
        Usuario user = Usuario.builder()
                .nombre(request.getUsername())
                .apellido(request.getApellido())
                .celular(request.getCelular())
                .correo(request.correo)
                .rol("u")
                .contraseña(passwordEncoder.encode(request.getContraseña()))
                .build();

        userService.createUser(user);
        return AuthResponse.builder().token(jwtService.getToken(user)).build();
    }
}
