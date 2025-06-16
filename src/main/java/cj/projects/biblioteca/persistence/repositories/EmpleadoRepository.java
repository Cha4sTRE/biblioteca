package cj.projects.biblioteca.persistence.repositories;

import cj.projects.biblioteca.persistence.entities.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity,Long> {

    Optional<EmpleadoEntity> findByUsername(String username);

}
