package cj.projects.biblioteca.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Builder
@Entity
@Table(name = "biblioteca")
public class BibliotecaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String direccion;
    private long telefono;
    private String email;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "biblioteca")
    private List<LibroEntity> libros=new ArrayList<>();

}
