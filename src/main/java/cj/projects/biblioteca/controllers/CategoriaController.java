package cj.projects.biblioteca.controllers;

import cj.projects.biblioteca.persistence.entities.CategoriaEntity;
import cj.projects.biblioteca.presentation.dtos.CategoriaDto;
import cj.projects.biblioteca.presentation.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/biblioteca/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping("/lista")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<List<CategoriaDto>> getAll(){
        List<CategoriaDto> categoria= categoriaService.findAll();
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<CategoriaDto> getById(@PathVariable long id){

        Optional<CategoriaDto> categoria= Optional.ofNullable(categoriaService.findById(id));
        if(categoria.isPresent()){
            return new ResponseEntity<>(categoria.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/agregar")
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity agregar(@RequestBody CategoriaEntity categoria){
        categoriaService.save(categoria);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    @PreAuthorize("hasAuthority('UPDATE')")
    public ResponseEntity actualizar(@RequestBody CategoriaEntity categoria, @PathVariable long id){
        categoriaService.update(categoria, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity eliminar(@PathVariable long id){
        categoriaService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
