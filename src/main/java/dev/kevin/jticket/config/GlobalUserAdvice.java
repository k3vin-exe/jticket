package dev.kevin.jticket.config;

import dev.kevin.jticket.config.JWTUserData;
import dev.kevin.jticket.entity.User;
import dev.kevin.jticket.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalUserAdvice {

    private final UserService userService;

    public GlobalUserAdvice(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("usuarioLogado")
    public User usuarioLogado() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.getPrincipal() instanceof JWTUserData jwt) {
            return userService.buscarPorId(jwt.userId());
        }

        return null;
    }
}