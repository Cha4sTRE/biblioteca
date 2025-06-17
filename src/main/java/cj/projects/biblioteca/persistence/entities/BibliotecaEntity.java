package cj.projects.biblioteca.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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
    private Set<LibroEntity> libros=new HashSet<>();

}
