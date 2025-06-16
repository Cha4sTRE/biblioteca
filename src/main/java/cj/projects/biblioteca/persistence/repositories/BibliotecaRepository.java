package cj.projects.biblioteca.persistence.repositories;

import cj.projects.biblioteca.persistence.entities.BibliotecaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecaRepository extends JpaRepository<BibliotecaEntity, Long> {
}
