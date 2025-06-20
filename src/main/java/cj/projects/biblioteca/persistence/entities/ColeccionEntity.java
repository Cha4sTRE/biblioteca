package cj.projects.biblioteca.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Builder
@Entity
@Table(name = "coleccion")
public class ColeccionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "coleccion")
    private List<LibroEntity> libros=new ArrayList<>();


}
