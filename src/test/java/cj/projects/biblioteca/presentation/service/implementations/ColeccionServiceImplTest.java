package cj.projects.biblioteca.presentation.service.implementations;

import cj.projects.biblioteca.persistence.entities.ColeccionEntity;
import cj.projects.biblioteca.persistence.repositories.ColeccionRepository;
import cj.projects.biblioteca.presentation.dtos.ColeccionDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ColeccionServiceImplTest {

    @Mock
    private ColeccionRepository coleccionRepository;
    @InjectMocks
    private ColeccionServiceImpl coleccionService;

    private ColeccionEntity coleccionEntity;

    @BeforeEach
    void setUp() {
        coleccionEntity= ColeccionEntity.builder()
                .id(1L)
                .nombre("Coleccion")
                .descripcion("Descripcion")
                .libros(Collections.emptyList()).build();
    }

    @Test
    void findAll() {

        List<ColeccionEntity> coleccionEntityList= List.of(coleccionEntity);

        when(coleccionRepository.findAll()).thenReturn(coleccionEntityList);
        List<ColeccionDto> result = coleccionService.findAll();

        assertNotNull(result);
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}