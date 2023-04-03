package com.renan.minha_api_restful.controllers;

import com.renan.minha_api_restful.entities.Usuario;
import com.renan.minha_api_restful.repositories.UsuarioRepository;
import com.renan.minha_api_restful.services.EmpresaService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }


    @PostMapping("/logar")
    public String logar(Model model, @RequestParam("username") String username, @RequestParam("password") String password){
        Usuario usuario = repository.findByUsername(username).get();
        if(usuario != null){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if(encoder.matches(password, usuario.getPassword())){
                return "redirect:/home";
            }
        }
        model.addAttribute("erro", "Usuários ou senha inválidos");
        return "login";
    }

}
