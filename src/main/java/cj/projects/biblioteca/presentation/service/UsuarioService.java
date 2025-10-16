package cj.projects.biblioteca.presentation.service;

import cj.projects.biblioteca.persistence.entities.UsuarioEntity;
import cj.projects.biblioteca.presentation.dtos.UsuarioDto;

public interface UsuarioService {

    UsuarioDto getUsuarioById(Long id);
    UsuarioDto addNewUsuario(UsuarioEntity usuarioEntity);


}
