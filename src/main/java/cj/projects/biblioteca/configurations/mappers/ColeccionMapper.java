package cj.projects.biblioteca.configurations.mappers;

import cj.projects.biblioteca.persistence.entities.ColeccionEntity;
import cj.projects.biblioteca.persistence.entities.LibroEntity;
import cj.projects.biblioteca.presentation.dtos.ColeccionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ColeccionMapper {

    ColeccionMapper INSTANCE = Mappers.getMapper(ColeccionMapper.class);
    @Mapping(target = "libros", source = "libros")
    ColeccionDto toColeccionDto(ColeccionEntity coleccionEntity);
    default List<String> mapLibrosToLibros(List<LibroEntity> libros) {
        if(libros == null){
            return Collections.emptyList();
        }
        return libros.stream().map(LibroEntity::getTitulo).collect(Collectors.toList());
    }
}
