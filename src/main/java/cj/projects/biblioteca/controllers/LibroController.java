package cj.projects.biblioteca.controllers;

import cj.projects.biblioteca.persistence.entities.LibroEntity;
import cj.projects.biblioteca.presentation.dtos.LibroDto;
import cj.projects.biblioteca.presentation.service.LibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<Page<LibroDto>> getAll(@RequestParam(name = "page",defaultValue = "0") int page) {
        Page<LibroDto> libros= libroService.findAll(page);
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
    public ResponseEntity<String> agregar(@RequestBody LibroEntity libro){
        libroService.save(libro);
        return new ResponseEntity<>("Libro agregado com exito", HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    @PreAuthorize("hasAuthority('UPDATE')")
    public ResponseEntity<String> actualizar(@RequestBody LibroEntity libro, @PathVariable long id){
        libroService.update(libro, id);
        return new ResponseEntity<>("Libro actualizado com exito", HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable long id){
        libroService.delete(id);
        return new ResponseEntity<>("Libro eliminado com exito", HttpStatus.OK);
    }

}
