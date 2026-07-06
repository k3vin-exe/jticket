package dev.kevin.jticket.controller;

import dev.kevin.jticket.config.JWTUserData;
import dev.kevin.jticket.entity.User;
import dev.kevin.jticket.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilController {

    private final UserService userService;

    public PerfilController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/perfil")
    public String perfil(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        JWTUserData jwt = (JWTUserData) auth.getPrincipal();

        User user = userService.buscarPorId(jwt.userId());

        model.addAttribute("usuario", user);

        return "perfil";
    }
}
