package com.unijorge.ods16.service;

import com.unijorge.ods16.exceptions.AppException;
import com.unijorge.ods16.model.Role;
import com.unijorge.ods16.model.User;
import com.unijorge.ods16.model.enums.RoleName;
import com.unijorge.ods16.model.records.ApiResponse;
import com.unijorge.ods16.model.records.SignUpRequest;
import com.unijorge.ods16.repository.RoleRepository;
import com.unijorge.ods16.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;

@Service
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public ResponseEntity<?> cadastro(SignUpRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.username())){
            return new ResponseEntity<>(new ApiResponse(false, "Nome de usuário já existe!"), HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByEmail(signUpRequest.email())){
            return new ResponseEntity<>(new ApiResponse(false, "O email informado já está registrado!"),HttpStatus.BAD_REQUEST);
        }

        User user = new User(signUpRequest.name(), signUpRequest.username(), signUpRequest.email(), signUpRequest.password());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(() -> new AppException("Permissão do usuário não configurada"));

        user.setRoles(Collections.singleton(userRole));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/{username}").buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Usuário registrado com sucesso!"));
    }
}
