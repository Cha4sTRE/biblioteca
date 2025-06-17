package cj.projects.biblioteca.presentation.dtos;

import cj.projects.biblioteca.persistence.entities.LibroEntity;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class BibliotecaDto {

    private String nombre;
    private String direccion;
    private long telefono;
    private String email;

    private Set<LibroEntity> libros=new HashSet<>();

}
