package cj.projects.biblioteca.presentation.service.implementations;

import cj.projects.biblioteca.persistence.entities.BibliotecaEntity;
import cj.projects.biblioteca.persistence.entities.LibroEntity;
import cj.projects.biblioteca.persistence.entities.PrestamoEntity;
import cj.projects.biblioteca.persistence.entities.UsuarioEntity;
import cj.projects.biblioteca.persistence.repositories.BibliotecaRepository;
import cj.projects.biblioteca.persistence.repositories.LibroRepository;
import cj.projects.biblioteca.persistence.repositories.PrestamoRepository;
import cj.projects.biblioteca.persistence.repositories.UsuarioRepository;
import cj.projects.biblioteca.presentation.dtos.PrestamoDto;
import cj.projects.biblioteca.presentation.service.PrestamoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PrestamoServiceImpl implements PrestamoService {
    private final UsuarioRepository usuarioRepository;
    private final BibliotecaRepository bibliotecaRepository;
    private final LibroRepository libroRepository;
    private final PrestamoRepository prestamoRepository;
    @Override
    public PrestamoDto addPrestamo(PrestamoDto prestamoDto) {
        UsuarioEntity usuario= usuarioRepository.findById(prestamoDto.getIdUsuario()).orElse(null);
        BibliotecaEntity biblioteca= bibliotecaRepository.findById(prestamoDto.getIdBiblioteca()).orElse(null);

        LibroEntity libro= libroRepository.findByTitulo(prestamoDto.getTitulo());
        PrestamoEntity prestamo= PrestamoEntity.builder()
                .usuario(usuario)
                .titulo(prestamoDto.getTitulo())
                .build();
        usuario.getPrestamos().add(prestamo);
        libro.setCantidad(libro.getCantidad()-1);
        prestamoRepository.save(prestamo);
        return prestamoDto;
    }
}
