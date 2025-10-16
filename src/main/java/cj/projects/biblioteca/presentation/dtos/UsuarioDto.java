package cj.projects.biblioteca.presentation.dtos;

import cj.projects.biblioteca.persistence.entities.PrestamoEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UsuarioDto {

    private String name;
    private String lastName;
    private List<PrestamoDto> prestamos= new ArrayList<>();

}
