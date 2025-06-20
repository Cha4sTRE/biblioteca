package cj.projects.biblioteca.configurations.mappers;

import cj.projects.biblioteca.persistence.entities.BibliotecaEntity;
import cj.projects.biblioteca.persistence.entities.LibroEntity;
import cj.projects.biblioteca.presentation.dtos.BibliotecaDto;
import cj.projects.biblioteca.presentation.dtos.LibroDto;
import org.hibernate.mapping.Collection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface BibliotecaMapper {

    BibliotecaMapper INSTANCE= Mappers.getMapper(BibliotecaMapper.class);

    @Mapping(target = "libros", source = "libros")
    BibliotecaDto toBibliotecaDto(BibliotecaEntity bibliotecaEntity);

    default List<String> mapLibrosToLibros(List<LibroEntity> libros) {
        if(libros == null){
            return Collections.emptyList();
        }
        return libros.stream().map(LibroEntity::getTitulo).collect(Collectors.toList());
    }

}
