package cj.projects.biblioteca.presentation.service.implementations;

import cj.projects.biblioteca.configurations.mappers.LibroMapper;
import cj.projects.biblioteca.persistence.entities.LibroEntity;
import cj.projects.biblioteca.persistence.repositories.LibroRepository;
import cj.projects.biblioteca.presentation.dtos.LibroDto;
import cj.projects.biblioteca.presentation.service.LibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LibroServiceImpl implements LibroService {
    private final LibroRepository libroRepository;
    @Override
    public List<LibroDto> findAll() {

        List<LibroEntity> libros = libroRepository.findAll();
        return libros.stream().map(LibroMapper.INSTANCE::toLibroDto).collect(Collectors.toList());

    }

    @Override
    public LibroDto findById(Long id) {
        return LibroMapper.INSTANCE.toLibroDto(libroRepository.findById(id).orElse(null));
    }

    @Override
    public void save(LibroEntity libro) {
        libroRepository.save(libro);
    }

    @Override
    public void update(LibroEntity libro, long id) {
        libro.setId(id);
        libroRepository.save(libro);
    }

    @Override
    public void delete(Long id) {
        libroRepository.deleteById(id);
    }
}
