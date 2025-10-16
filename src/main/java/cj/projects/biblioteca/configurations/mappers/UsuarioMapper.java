package cj.projects.biblioteca.configurations.mappers;

import cj.projects.biblioteca.persistence.entities.PrestamoEntity;
import cj.projects.biblioteca.persistence.entities.UsuarioEntity;
import cj.projects.biblioteca.presentation.dtos.PrestamoDto;
import cj.projects.biblioteca.presentation.dtos.UsuarioDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDto toUsuarioDto(UsuarioEntity usuarioEntity);
    List<PrestamoDto> toPrestamosDto(List<PrestamoEntity> prestamosEntity);
    UsuarioEntity toUsuarioEntity(UsuarioDto usuarioDto);
}
