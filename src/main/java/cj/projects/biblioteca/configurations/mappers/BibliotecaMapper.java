package cj.projects.biblioteca.configurations.mappers;

import cj.projects.biblioteca.persistence.entities.BibliotecaEntity;
import cj.projects.biblioteca.presentation.dtos.BibliotecaDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BibliotecaMapper {

    BibliotecaMapper INSTANCE= Mappers.getMapper(BibliotecaMapper.class);
    BibliotecaDto toBibliotecaDto(BibliotecaEntity bibliotecaEntity);

}
