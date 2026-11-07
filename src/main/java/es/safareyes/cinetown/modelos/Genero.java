package es.safareyes.cinetown.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "genero", schema = "cinetown")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(mappedBy = "generos")
    private List<Pelicula> peliculas;
}
