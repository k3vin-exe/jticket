package dev.kevin.jticket.service;

import dev.kevin.jticket.entity.Chamado;
import dev.kevin.jticket.enums.StatusChamado;
import dev.kevin.jticket.repository.ChamadoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChamadoService {

    private final ChamadoRepository repository;

    public ChamadoService(ChamadoRepository repository) {
        this.repository = repository;
    }

    public List<Chamado> listarTodos() {
        return repository.findAll();
    }

    public List<Chamado> buscarPorTitulo(String titulo) {
        return repository.findByTituloContainingIgnoreCase(titulo);
    }

    public Chamado buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado."));
    }

    public Chamado salvar(Chamado chamado) {

        if (chamado.getId() == null) {
            chamado.setDataAbertura(LocalDateTime.now());

            if (chamado.getStatus() == null) {
                chamado.setStatus(StatusChamado.ABERTO);
            }

            return repository.save(chamado);
        }

        Chamado existente = buscarPorId(chamado.getId());

        existente.setTitulo(chamado.getTitulo());
        existente.setDescricao(chamado.getDescricao());
        existente.setCategoria(chamado.getCategoria());
        existente.setPrioridade(chamado.getPrioridade());
        existente.setStatus(chamado.getStatus());

        if (existente.getStatus() == StatusChamado.FECHADO
                && existente.getDataFechamento() == null) {
            existente.setDataFechamento(LocalDateTime.now());
        }

        return repository.save(existente);
    }

    public void deletar(Long id) {
        System.out.println("Repository delete " + id);

        repository.deleteById(id);
    }

}