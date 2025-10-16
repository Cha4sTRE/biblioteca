package cj.projects.biblioteca.controllers;

import cj.projects.biblioteca.presentation.dtos.PrestamoDto;
import cj.projects.biblioteca.presentation.service.PrestamoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/biblioteca/prestamos")
@RequiredArgsConstructor
public class PrestamoController {
    private final PrestamoService prestamoService;
    @PostMapping("/new")
    public PrestamoDto newPrestamo(@RequestBody PrestamoDto prestamoDto) {
        return prestamoService.addPrestamo(prestamoDto);
    }

}
