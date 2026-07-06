package dev.kevin.jticket.config;

import dev.kevin.jticket.config.JWTUserData;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalUserAdvice {

    @ModelAttribute("usuarioLogado")
    public JWTUserData usuarioLogado() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.getPrincipal() instanceof JWTUserData user) {
            return user;
        }

        return null;
    }
}