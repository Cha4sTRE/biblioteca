package cj.projects.biblioteca.presentation.dtos;

import lombok.Data;

@Data
public class PrestamoDto {
    Long idUsuario;
    Long idBiblioteca;
    String titulo;
}
