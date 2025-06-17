package cj.projects.biblioteca.presentation.service;

import cj.projects.biblioteca.persistence.entities.ColeccionEntity;
import cj.projects.biblioteca.persistence.entities.LibroEntity;
import cj.projects.biblioteca.presentation.dtos.ColeccionDto;
import cj.projects.biblioteca.presentation.dtos.LibroDto;

import java.util.List;

public interface ColeccionService {

    List<ColeccionDto> findAll();
    ColeccionDto findById(Long id);
    void save(ColeccionEntity coleccion);
    void update(ColeccionEntity coleccion, long id);
    void delete(Long id);

}
