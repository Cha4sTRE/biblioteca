package cj.projects.biblioteca.persistence.repositories;

import cj.projects.biblioteca.persistence.entities.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<LibroEntity, Long> {


}
