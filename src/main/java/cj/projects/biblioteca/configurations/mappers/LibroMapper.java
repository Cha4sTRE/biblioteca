package cj.projects.biblioteca.configurations.mappers;

import cj.projects.biblioteca.persistence.entities.LibroEntity;
import cj.projects.biblioteca.presentation.dtos.LibroDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LibroMapper {

    LibroMapper INSTANCE = Mappers.getMapper(LibroMapper.class);

    //@Mapping(target = "categoria", source = "libroEntity.categoria.nombre")
    //@Mapping(target = "coleccion", source = "libroEntity.coleccion.nombre")
    //@Mapping(target = "biblioteca", source = "libroEntity.biblioteca.nombre")
    //LibroDto toLibroDto (LibroEntity libroEntity);

}
