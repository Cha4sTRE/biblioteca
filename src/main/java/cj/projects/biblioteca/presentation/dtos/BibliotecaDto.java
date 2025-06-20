package cj.projects.biblioteca.presentation.dtos;

import lombok.Data;


import java.util.List;


@Data
public class BibliotecaDto {

    private String nombre;
    private String direccion;
    private long telefono;
    private String email;

    private List<String> libros;

}
