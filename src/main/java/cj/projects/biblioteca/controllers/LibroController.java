package cj.projects.biblioteca.controllers;

import cj.projects.biblioteca.persistence.entities.LibroEntity;
import cj.projects.biblioteca.presentation.dtos.LibroDto;
import cj.projects.biblioteca.presentation.service.LibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/biblioteca/libros")
public class LibroController {

    private final LibroService libroService;

    @GetMapping("/lista")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<List<LibroDto>> getAll(){
        List<LibroDto> libros= libroService.findAll();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<LibroDto> getById(@PathVariable long id){

        Optional<LibroDto> libro= Optional.ofNullable(libroService.findById(id));
        if(libro.isPresent()){
            return new ResponseEntity<>(libro.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/agregar")
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity agregar(@RequestBody LibroEntity libro){
        libroService.save(libro);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/actualizar/{id}")
    @PreAuthorize("hasAuthority('UPDATE')")
    public ResponseEntity actualizar(@RequestBody LibroEntity libro, @PathVariable long id){
        libroService.update(libro, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity eliminar(@PathVariable long id){
        libroService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
