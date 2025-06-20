package cj.projects.biblioteca.controllers;

import cj.projects.biblioteca.persistence.entities.ColeccionEntity;
import cj.projects.biblioteca.presentation.dtos.ColeccionDto;
import cj.projects.biblioteca.presentation.service.ColeccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/biblioteca/coleccion")
public class ColeccionController {

    private final ColeccionService coleccionService;

    @GetMapping("/lista")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<List<ColeccionDto>> getAll(){
        List<ColeccionDto> colecciones= coleccionService.findAll();
        return new ResponseEntity<>(colecciones, HttpStatus.OK);
    }

    @GetMapping("buscar/{id}")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<ColeccionDto> getById(@PathVariable long id){

        Optional<ColeccionDto> coleccion= Optional.ofNullable(coleccionService.findById(id));
        if(coleccion.isPresent()){
            return new ResponseEntity<>(coleccion.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/agregar")
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity agregar(@RequestBody ColeccionEntity coleccion){
        coleccionService.save(coleccion);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    @PreAuthorize("hasAuthority('UPDATE')")
    public ResponseEntity actualizar(@RequestBody ColeccionEntity coleccion, @PathVariable long id){
        coleccionService.update(coleccion, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity eliminar(@PathVariable long id){
        coleccionService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
