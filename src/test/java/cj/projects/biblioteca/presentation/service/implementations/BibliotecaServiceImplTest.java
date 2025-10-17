package cj.projects.biblioteca.presentation.service.implementations;

import cj.projects.biblioteca.configurations.mappers.BibliotecaMapper;
import cj.projects.biblioteca.persistence.entities.BibliotecaEntity;
import cj.projects.biblioteca.persistence.entities.LibroEntity;
import cj.projects.biblioteca.persistence.repositories.BibliotecaRepository;
import cj.projects.biblioteca.presentation.dtos.BibliotecaDto;
import cj.projects.biblioteca.presentation.dtos.LibroDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BibliotecaServiceImplTest {

    @Mock
    private BibliotecaRepository bibliotecaRepository;
    @InjectMocks
    private BibliotecaServiceImpl bibliotecaServiceImpl;

    BibliotecaEntity bibliotecaEntity;
    private BibliotecaDto bibliotecaDto;
    LibroEntity libroEntity;
    private LibroDto libroDto;

    @BeforeEach
    void setUp() {
        bibliotecaEntity = BibliotecaEntity.builder()
                .id(1L)
                .nombre("Biblioteca Nacional")
                .direccion("calle gran colombia")
                .email("Nacional@gmail.co")
                .libros(Collections.emptyList())
                .build();
        bibliotecaDto = new BibliotecaDto();
        bibliotecaDto.setNombre("Biblioteca Nacional");
        bibliotecaDto.setDireccion("calle gran colombia");
        bibliotecaDto.setEmail("Nacional@gmail.co");
        bibliotecaDto.setLibros(Collections.emptyList());
    }

    @Test
    void list() {

        List<BibliotecaDto> listTest= List.of(bibliotecaDto);
        List<BibliotecaEntity> bibliotecaEntities = List.of(bibliotecaEntity);

        when(bibliotecaRepository.findAll()).thenReturn(bibliotecaEntities);

        List<BibliotecaDto> list = bibliotecaServiceImpl.list();

        assertNotNull(list);
        assertEquals(listTest,list);
    }

    @Test
    void getById() {


        when(bibliotecaRepository.findById(1L)).thenReturn(Optional.of(bibliotecaEntity));

        BibliotecaDto result= bibliotecaServiceImpl.getById(1L);
        assertNotNull(result);
        assertEquals(bibliotecaDto,result);

    }

    @Test
    void save() {

        when(bibliotecaRepository.save(any(BibliotecaEntity.class))).thenReturn(bibliotecaEntity);
        bibliotecaServiceImpl.save(bibliotecaEntity);
        verify(bibliotecaRepository).save(any(BibliotecaEntity.class));


    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}