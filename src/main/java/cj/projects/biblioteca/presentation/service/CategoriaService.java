package cj.projects.biblioteca.presentation.service;

import cj.projects.biblioteca.persistence.entities.CategoriaEntity;
import cj.projects.biblioteca.presentation.dtos.CategoriaDto;

import java.util.List;

public interface CategoriaService {

    List<CategoriaDto> findAll();
    CategoriaDto findById(Long id);
    void save(CategoriaEntity categoria);
    void update(CategoriaEntity categoria, long id);
    void delete(Long id);

}
