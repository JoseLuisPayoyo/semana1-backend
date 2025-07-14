package com.jose.securuty_jwt.controllers;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jose.securuty_jwt.models.ERole;
import com.jose.securuty_jwt.models.RoleEntity;
import com.jose.securuty_jwt.models.UserEntity;
import com.jose.securuty_jwt.repositories.UserRepository;
import com.jose.securuty_jwt.request.CreateUserDTO;

import jakarta.validation.Valid;

@RestController
public class PrincipalController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/hello")
    public String hello(){
        return "Hola no seguro";
    }

    @GetMapping("/helloSecured")
    public String helloSecured(){
        return "Hola seguro";
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO createUserDTO){
        
        Set<RoleEntity> roles = createUserDTO.getRoles().stream()
                    .map(role -> RoleEntity.builder()
                        .name(ERole.valueOf(role))
                        .build())
                    .collect(Collectors.toSet());
        
        UserEntity userEntity = UserEntity.builder()
                    .username(createUserDTO.getUsername())
                    .password(createUserDTO.getPassword())
                    .email(createUserDTO.getEmail())
                    .roles(roles)
                    .build();

        userRepository.save(userEntity);

        return ResponseEntity.ok(userEntity);            
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam String id){
        userRepository.deleteById(Long.parseLong(id));
        return "Se ha borrado el user con id".concat(id);
    }

}
