package cj.projects.biblioteca.presentation.service.implementations;

import cj.projects.biblioteca.configurations.mappers.BibliotecaMapper;
import cj.projects.biblioteca.persistence.entities.BibliotecaEntity;
import cj.projects.biblioteca.persistence.repositories.BibliotecaRepository;
import cj.projects.biblioteca.presentation.dtos.BibliotecaDto;
import cj.projects.biblioteca.presentation.service.BibliotecaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BibliotecaServiceImpl implements BibliotecaService {
    private final BibliotecaRepository bibliotecaRepository;
    @Override
    public List<BibliotecaDto> list() {
        List<BibliotecaEntity> bibliotecaEntities = bibliotecaRepository.findAll();
        List<BibliotecaDto> bibliotecaDtos = bibliotecaEntities.stream().map(BibliotecaMapper.INSTANCE::toBibliotecaDto).collect(Collectors.toList());
        return bibliotecaDtos;
    }

    @Override
    public BibliotecaDto getById(long id) {
        return BibliotecaMapper.INSTANCE.toBibliotecaDto(bibliotecaRepository.findById(id));
    }

    @Override
    public void save(BibliotecaEntity biblioteca) {
        bibliotecaRepository.save(biblioteca);
    }

    @Override
    public void update(BibliotecaEntity biblioteca,long id) {
        biblioteca.setId(id);
        bibliotecaRepository.save(biblioteca);
    }

    @Override
    public void delete(long id) {
        bibliotecaRepository.deleteById(id);
    }
}
