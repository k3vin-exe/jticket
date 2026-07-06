package dev.kevin.jticket.controller;

import dev.kevin.jticket.config.JWTUserData;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilController {
    @GetMapping("/perfil")
    public String perfil(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        JWTUserData user = (JWTUserData) auth.getDetails();

        model.addAttribute("usuario", user);

        return "perfil";
    }
}
