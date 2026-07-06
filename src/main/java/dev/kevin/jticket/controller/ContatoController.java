package dev.kevin.jticket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContatoController {

    @GetMapping("/contato")
    public String formContato() {
        return "contato";
    }

    @PostMapping("/contato")
    public String enviarContato() {
        return "redirect:/contato/sucesso";
    }

    @GetMapping("/contato/sucesso")
    public String sucesso() {
        return "contato-sucesso";
    }
}