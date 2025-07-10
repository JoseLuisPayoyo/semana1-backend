package com.payoyo.gestionusuarios.controller;

import com.payoyo.gestionusuarios.entity.Usuario;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping("/me")
    public Usuario verPerfil(@AuthenticationPrincipal Usuario usuario) {
        return usuario;
    }
}
