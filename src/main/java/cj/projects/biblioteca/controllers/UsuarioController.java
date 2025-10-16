package cj.projects.biblioteca.controllers;

import cj.projects.biblioteca.configurations.mappers.UsuarioMapper;
import cj.projects.biblioteca.presentation.dtos.UsuarioDto;
import cj.projects.biblioteca.presentation.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/biblioteca/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;
    @GetMapping("/find/{id}")
    public UsuarioDto getUsuario(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }
    @PostMapping("/new")
    public UsuarioDto addNewUsuario(@RequestBody UsuarioDto usuarioDto) {
        return usuarioService.addNewUsuario(usuarioMapper.toUsuarioEntity(usuarioDto));
    }
}
