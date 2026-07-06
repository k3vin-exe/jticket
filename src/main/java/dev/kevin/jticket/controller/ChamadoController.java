package dev.kevin.jticket.controller;

import dev.kevin.jticket.entity.Chamado;
import dev.kevin.jticket.service.ChamadoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chamados")
public class ChamadoController {

    private final ChamadoService service;

    public ChamadoController(ChamadoService service) {
        this.service = service;
    }

    // Lista todos ou pesquisa por título
    @GetMapping
    public String listar(
            @RequestParam(required = false) String titulo,
            Model model) {

        if (titulo != null && !titulo.isBlank()) {
            model.addAttribute("chamados", service.buscarPorTitulo(titulo));
        } else {
            model.addAttribute("chamados", service.listarTodos());
        }

        model.addAttribute("tituloBusca", titulo);

        return "chamados";
    }

    // Formulário de criação
    @GetMapping("/novo")
    public String novo(Model model) {

        Chamado chamado = new Chamado();

        model.addAttribute("chamado", chamado);

        return "chamado-form";
    }

    // Salvar (criação ou edição)
    @PostMapping
    public String salvar(@ModelAttribute Chamado chamado) {

        service.salvar(chamado);

        return "redirect:/chamados";
    }

    // Visualizar
    @GetMapping("/{id}")
    public String visualizar(
            @PathVariable Long id,
            Model model) {

        model.addAttribute("chamado", service.buscarPorId(id));

        return "chamado-detalhes";
    }

    // Formulário de edição
    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model) {

        model.addAttribute("chamado", service.buscarPorId(id));

        return "chamado-form";
    }

    // Excluir
    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {

        System.out.println("DELETANDO " + id);

        service.deletar(id);

        return "redirect:/chamados";
    }

}