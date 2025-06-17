package cj.projects.biblioteca.configurations.mappers;

import cj.projects.biblioteca.persistence.entities.ColeccionEntity;
import cj.projects.biblioteca.presentation.dtos.ColeccionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ColeccionMapper {

    ColeccionMapper INSTANCE = Mappers.getMapper(ColeccionMapper.class);
    ColeccionDto toColeccionDto(ColeccionEntity coleccionEntity);

}
