package cj.projects.biblioteca.presentation.service.implementations;

import cj.projects.biblioteca.configurations.mappers.UsuarioMapper;
import cj.projects.biblioteca.persistence.entities.UsuarioEntity;
import cj.projects.biblioteca.persistence.repositories.UsuarioRepository;
import cj.projects.biblioteca.presentation.dtos.UsuarioDto;
import cj.projects.biblioteca.presentation.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    @Override
    public UsuarioDto getUsuarioById(Long id) {
        usuarioRepository.findById(id).orElse(null);
        return usuarioMapper.toUsuarioDto(usuarioRepository.findById(id).get());
    }

    @Override
    public UsuarioDto addNewUsuario(UsuarioEntity usuarioEntity) {
        usuarioRepository.save(usuarioEntity);
        return usuarioMapper.toUsuarioDto(usuarioEntity);
    }
}
