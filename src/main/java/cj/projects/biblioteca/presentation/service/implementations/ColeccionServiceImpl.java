package cj.projects.biblioteca.presentation.service.implementations;

import cj.projects.biblioteca.configurations.mappers.ColeccionMapper;
import cj.projects.biblioteca.persistence.entities.ColeccionEntity;
import cj.projects.biblioteca.persistence.repositories.ColeccionRepository;
import cj.projects.biblioteca.presentation.dtos.ColeccionDto;
import cj.projects.biblioteca.presentation.service.ColeccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ColeccionServiceImpl implements ColeccionService {
    private final ColeccionRepository coleccionRepository;
    @Override
    public List<ColeccionDto> findAll() {
        List<ColeccionEntity> entities= coleccionRepository.findAll();
        return entities.stream().map(ColeccionMapper.INSTANCE::toColeccionDto).collect(Collectors.toList());
    }

    @Override
    public ColeccionDto findById(Long id) {
        return ColeccionMapper.INSTANCE.toColeccionDto(coleccionRepository.findById(id).orElse(null));
    }

    @Override
    public void save(ColeccionEntity coleccion) {
        coleccionRepository.save(coleccion);
    }

    @Override
    public void update(ColeccionEntity coleccion, long id) {
        coleccion.setId(id);
        coleccionRepository.save(coleccion);
    }

    @Override
    public void delete(Long id) {
        coleccionRepository.deleteById(id);
    }
}
