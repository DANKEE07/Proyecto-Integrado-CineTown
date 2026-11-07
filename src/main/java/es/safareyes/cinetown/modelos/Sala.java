package es.safareyes.cinetown.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sala", schema = "cinetown")
@AllArgsConstructor
@NoArgsConstructor
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "capacidad", nullable = false)
    private int capacidad;

    @OneToMany(mappedBy = "sala")
    private List<Sesion> sesiones = new ArrayList<>();
}
