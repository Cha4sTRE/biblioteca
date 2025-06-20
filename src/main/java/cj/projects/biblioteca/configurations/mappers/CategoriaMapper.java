package cj.projects.biblioteca.configurations.mappers;

import cj.projects.biblioteca.persistence.entities.CategoriaEntity;
import cj.projects.biblioteca.presentation.dtos.CategoriaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);
    CategoriaDto toCategoriaDto(CategoriaEntity categoriaEntity);

}
