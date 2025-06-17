package cj.projects.biblioteca.presentation.service.implementations;

import cj.projects.biblioteca.configurations.mappers.CategoriaMapper;
import cj.projects.biblioteca.persistence.entities.CategoriaEntity;
import cj.projects.biblioteca.persistence.repositories.CategoriaRepository;
import cj.projects.biblioteca.presentation.dtos.CategoriaDto;
import cj.projects.biblioteca.presentation.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository categoriaRepository;
    @Override
    public List<CategoriaDto> findAll() {
        List<CategoriaEntity> entities= categoriaRepository.findAll();
        return entities.stream().map(CategoriaMapper.INSTANCE::toCategoriaDto).collect(Collectors.toList());
    }

    @Override
    public CategoriaDto findById(Long id) {
        return CategoriaMapper.INSTANCE.toCategoriaDto(categoriaRepository.findById(id).get());
    }

    @Override
    public void save(CategoriaEntity categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public void update(CategoriaEntity categoria, long id) {
        categoria.setId(id);
        categoriaRepository.save(categoria);
    }

    @Override
    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }
}
