package com.example.crudrapido.controller;
import java.util.Map;
import com.example.crudrapido.dto.AuthRequest;
import com.example.crudrapido.dto.AuthResponse;
import com.example.crudrapido.entity.UserEntity;
import com.example.crudrapido.repository.UserRepository;
import com.example.crudrapido.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    // 1. Endpoint para REGISTRAR un nuevo usuario
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest request) {
        // Verificar si el correo ya existe
        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body(Map.of("error", "El email ya está registrado."));
        }

        // Crear el usuario y ENCRIPTAR la contraseña
        UserEntity user = new UserEntity();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        return ResponseEntity.ok(Map.of("mensaje", "Usuario registrado exitosamente."));
    }

    // 2. Endpoint para INICIAR SESIÓN y obtener el Token JWT
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        // Spring Security verifica automáticamente si la contraseña coincide con la encriptada
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        // Si las credenciales son correctas, generamos el Token JWT
        String jwt = jwtUtil.generateToken(request.getEmail());

        // Devolvemos el Token en formato JSON usando nuestro DTO
        return ResponseEntity.ok(new AuthResponse(jwt));
    }
}