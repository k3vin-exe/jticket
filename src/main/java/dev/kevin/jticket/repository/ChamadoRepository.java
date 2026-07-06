package dev.kevin.jticket.repository;

import dev.kevin.jticket.entity.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

    List<Chamado> findByTituloContainingIgnoreCase(String titulo);

}