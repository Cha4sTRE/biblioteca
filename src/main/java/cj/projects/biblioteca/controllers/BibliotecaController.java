package cj.projects.biblioteca.controllers;

import cj.projects.biblioteca.persistence.entities.BibliotecaEntity;
import cj.projects.biblioteca.presentation.dtos.BibliotecaDto;
import cj.projects.biblioteca.presentation.service.BibliotecaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/biblioteca")
public class BibliotecaController {

    private final BibliotecaService bibliotecaService;

    @GetMapping("/lista")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<List<BibliotecaDto>> bibliotecas() {
        List<BibliotecaDto> bibliotecas= bibliotecaService.list();
        return ResponseEntity.ok(bibliotecas);
    }
    @GetMapping("/buscar/{id}")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<BibliotecaDto> biblioteca(@PathVariable Long id) {
        Optional<BibliotecaDto> bibliotecaOption= Optional.ofNullable(bibliotecaService.getById(id));
        if(!bibliotecaOption.isPresent()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return ResponseEntity.ok(bibliotecaOption.get());
        }
    }
    @PostMapping("/nueva")
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity crear(@RequestBody BibliotecaEntity biblioteca){
        bibliotecaService.save(biblioteca);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/actualizar/{id}")
    @PreAuthorize("hasAuthority('UPDATE')")
    public ResponseEntity actualizar(@RequestBody BibliotecaEntity biblioteca,@PathVariable Long id){
        biblioteca.setId(id);
        bibliotecaService.save(biblioteca);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('DELETE')")
    public ResponseEntity eliminar(@PathVariable Long id){
        bibliotecaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
