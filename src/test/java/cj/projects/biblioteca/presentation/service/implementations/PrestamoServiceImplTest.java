package cj.projects.biblioteca.presentation.service.implementations;

import cj.projects.biblioteca.persistence.entities.BibliotecaEntity;
import cj.projects.biblioteca.persistence.entities.LibroEntity;
import cj.projects.biblioteca.persistence.entities.PrestamoEntity;
import cj.projects.biblioteca.persistence.entities.UsuarioEntity;
import cj.projects.biblioteca.persistence.repositories.BibliotecaRepository;
import cj.projects.biblioteca.persistence.repositories.LibroRepository;
import cj.projects.biblioteca.persistence.repositories.PrestamoRepository;
import cj.projects.biblioteca.persistence.repositories.UsuarioRepository;
import cj.projects.biblioteca.presentation.dtos.LibroDto;
import cj.projects.biblioteca.presentation.dtos.PrestamoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PrestamoServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private BibliotecaRepository bibliotecaRepository;
    @Mock
    private LibroRepository libroRepository;
    @Mock
    private PrestamoRepository prestamoRepository;
    @InjectMocks
    private PrestamoServiceImpl prestamoService;

    private UsuarioEntity usuarioEntity;
    private BibliotecaEntity bibliotecaEntity;
    private LibroEntity libroEntity;

    @BeforeEach
    void setUp() {
        usuarioEntity = UsuarioEntity.builder()
                .id(1L)
                .name("Jefferson")
                .lastName("Chaustre")
                .prestamos(new ArrayList<>()) // importante que sea modificable
                .build();

        bibliotecaEntity = BibliotecaEntity.builder()
                .id(1L)
                .nombre("Biblioteca Nacional")
                .build();

        libroEntity = LibroEntity.builder()
                .id(10L)
                .titulo("El Silmarillion")
                .isbn("12345")
                .cantidad(5)
                .build();
    }

    @Test
    void addPrestamo() {
        // Arrange
        PrestamoDto prestamoDto = new PrestamoDto();
        prestamoDto.setIdUsuario(usuarioEntity.getId());
        prestamoDto.setIdBiblioteca(bibliotecaEntity.getId());
        prestamoDto.setTitulo("El Silmarillion");
        prestamoDto.setIsbn("12345");

        when(usuarioRepository.findById(usuarioEntity.getId())).thenReturn(Optional.of(usuarioEntity));
        when(bibliotecaRepository.findById(bibliotecaEntity.getId())).thenReturn(Optional.of(bibliotecaEntity));
        when(libroRepository.findByTitulo("El Silmarillion")).thenReturn(libroEntity);
        when(prestamoRepository.save(any(PrestamoEntity.class)))
                .thenAnswer(invocation -> invocation.getArgument(0)); // simula el guardado

        // Act
        PrestamoDto resultado = prestamoService.addPrestamo(prestamoDto);

        // Assert
        assertNotNull(resultado);
        assertEquals(prestamoDto.getTitulo(), resultado.getTitulo());
        assertEquals(prestamoDto.getIsbn(), resultado.getIsbn());
        assertEquals(4, libroEntity.getCantidad()); // cantidad debe bajar de 5 a 4
        assertEquals(1, usuarioEntity.getPrestamos().size()); // debe agregarse un préstamo
        verify(prestamoRepository, times(1)).save(any(PrestamoEntity.class));
        verify(usuarioRepository).findById(usuarioEntity.getId());
        verify(bibliotecaRepository).findById(bibliotecaEntity.getId());
        verify(libroRepository).findByTitulo("El Silmarillion");
    }
}