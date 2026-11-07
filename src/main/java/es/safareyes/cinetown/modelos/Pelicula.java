package es.safareyes.cinetown.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pelicula", schema = "cinetown")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "activo")
    private Boolean activo;

    @Column(name = "anio")
    private int anio;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "clasificacion")
    private String clasificacion;

    @Column(name = "duracion")
    private int duracion;

    @Column(name = "sinopsis")
    private String sinopsis;

    /* Esto es la N:M, como la tabla pelicula_genero no tiene datos propios (solo tiene id_pelicula y id_genero)
    no hace falta crear una clase "pelicula_genero"

    Al no crear la clase "pelicula_genero", tenemos que asignarle esa tabla a una clase, la que sea más coherente,
    yo he elegido asignársela a esta, entonces marcamos que esta es la dueña de la relación (con el JoinTable).

    En la otra tabla (que sería Genero en este caso), como no es la dueña no hace falta poner el JoinTable.
    Simplemente ponemos que es una N:M (ManyToMany) y que está mapeada (mappedBy) y la lista por la que está mapeada
    (En este caso sería "Generos").

    */

    @ManyToMany
    @JoinTable(name = "pelicula_genero", joinColumns = @JoinColumn(name = "id_pelicula"), inverseJoinColumns = @JoinColumn(name = "id_genero"))
    private List<Genero> generos;
}
