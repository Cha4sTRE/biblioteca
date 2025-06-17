package cj.projects.biblioteca.presentation.service;

import cj.projects.biblioteca.persistence.entities.LibroEntity;
import cj.projects.biblioteca.presentation.dtos.LibroDto;

import java.util.List;

public interface LibroService {

    List<LibroDto> findAll();
    LibroDto findById(Long id);
    void save(LibroEntity libro);
    void update(LibroEntity libro, long id);
    void delete(Long id);

}
