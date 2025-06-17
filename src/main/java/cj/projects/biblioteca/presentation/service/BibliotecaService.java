package cj.projects.biblioteca.presentation.service;

import cj.projects.biblioteca.persistence.entities.BibliotecaEntity;
import cj.projects.biblioteca.presentation.dtos.BibliotecaDto;

import java.util.List;
import java.util.Optional;

public interface BibliotecaService {

    List<BibliotecaDto> list();
    BibliotecaDto getById(long id);
    void save(BibliotecaEntity biblioteca);
    void update(BibliotecaEntity biblioteca,long id);
    void delete(long id);

}
