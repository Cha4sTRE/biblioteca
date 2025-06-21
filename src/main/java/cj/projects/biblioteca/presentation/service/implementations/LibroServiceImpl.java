package cj.projects.biblioteca.presentation.service.implementations;

import cj.projects.biblioteca.configurations.mappers.LibroMapper;
import cj.projects.biblioteca.persistence.entities.LibroEntity;
import cj.projects.biblioteca.persistence.repositories.LibroRepository;
import cj.projects.biblioteca.presentation.dtos.LibroDto;
import cj.projects.biblioteca.presentation.service.LibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    @Override
    public Page<LibroDto> findAll(int page) {

        Page<LibroEntity> pages= libroRepository.findAll(PageRequest.of(page, 5));
        Page<LibroDto> pagesDtos= pages.map(LibroMapper.INSTANCE::toLibroDto);
        return pagesDtos;

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
