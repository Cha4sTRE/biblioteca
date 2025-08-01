package cj.projects.biblioteca.persistence.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Builder
@Entity
@Table(name = "libro")
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String isbn;
    private String editorial;
    private Integer cantidad;
    private BigInteger precio;

    @Column(name = "fecha_publicacion")
    private String fechaPublicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CategoriaEntity categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coleccion_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ColeccionEntity coleccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "biblioteca_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private BibliotecaEntity biblioteca;


}
