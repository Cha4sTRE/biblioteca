package cj.projects.biblioteca.persistence.repositories;

import cj.projects.biblioteca.persistence.entities.ColeccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColeccionRepository extends JpaRepository<ColeccionEntity, Long> {
}
