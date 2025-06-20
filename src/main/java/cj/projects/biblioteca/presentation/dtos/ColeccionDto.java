package cj.projects.biblioteca.presentation.dtos;

import cj.projects.biblioteca.persistence.entities.LibroEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class ColeccionDto {

    private String nombre;
    private String descripcion;

    private List<String> libros=new ArrayList<>();

}
