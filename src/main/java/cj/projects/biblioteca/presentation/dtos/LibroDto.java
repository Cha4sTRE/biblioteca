package cj.projects.biblioteca.presentation.dtos;

import lombok.Data;

import java.math.BigInteger;


@Data
public class LibroDto {

    private String titulo;
    private String autor;
    private String isbn;
    private String editorial;
    private String fechaPublicacion;
    private Integer cantidad;
    private BigInteger precio;
    private String categoria;
    private String coleccion;
    private String biblioteca;

}
