package es.safareyes.cinetown.dtos;

import jakarta.validation.constraints.*;

import java.util.List;

public record CrearPeliculaDTO(

// También uso este DTO para Modificar las películas, iba a hacer un ModificarPeliculaDTO pero he visto
// que al final sería lo mismo, así que para evitar duplicar código he usado este también
// en el Endpoint 4 -> PUT (Modificación de Película)


        @NotNull
        Integer anio,

        @NotBlank
        String titulo,

        @NotBlank
        @Pattern(regexp = "^(TP|MAYORES_7|MAYORES_12|MAYORES_16|MAYORES_18)$", message = "Clasificación no válida, debe ser TP, MAYORES_7, MAYORES_12, MAYORES_16 o MAYORES_18")
        String clasificacion,

        @Min(1)
        @Max(300)
        @NotNull
        Integer duracion,

        @NotBlank
        String sinopsis,

        @NotEmpty
        List<Integer> generos
) {
}
