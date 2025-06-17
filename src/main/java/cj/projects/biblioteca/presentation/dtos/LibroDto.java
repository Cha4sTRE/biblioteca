package cj.projects.biblioteca.presentation.dtos;

import lombok.Data;


@Data
public class LibroDto {

    private String titulo;
    private String autor;
    private String isbn;
    private String editorial;
    private String fechaPublicacion;
    private String categoriaNombre;
    private String coleccionNombre;
    private String bibliotecaNombre;

}
