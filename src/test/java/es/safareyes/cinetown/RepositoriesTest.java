package es.safareyes.cinetown;//package es.safareyes.cinetown;
//
//import es.safareyes.cinetown.modelos.Genero;
//import es.safareyes.cinetown.modelos.Pelicula;
//import es.safareyes.cinetown.repositorios.IPeliculaRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//import java.util.Optional;
//
//@SpringBootTest
//public class RepositoriesTest {
//
//    @Autowired
//    private IPeliculaRepository peliculaRepository;
//
//    @Test
//    void probarConexion() {
//
//        System.out.println("========== INICIO TEST ==========");
//
//        long cantidad = peliculaRepository.count();
//
//        System.out.println("Número de películas: " + cantidad);
//
//        System.out.println("========== FIN TEST ==========");
//    }
//
//    @Test
//    void buscarPorTitulo() {
//        System.out.println("========== INICIO TEST 2 ==========");
//
//        List<Pelicula> peliculas = peliculaRepository.buscarPorTitulo("%o");
//        //IMPORTANTE -> Diferencia de mayúsculas (no es lo mismo (%A) que (%a))
//        //buscarPorTitulo("%");       // Todas
//        //buscarPorTitulo("A%");      // Empiezan por A
//        //buscarPorTitulo("Av%");     // Empiezan por Av
//        //buscarPorTitulo("%man%");   // Contienen "man"
//        //buscarPorTitulo("%a");      // Terminan en "a"
//
//        System.out.println("Número de películas encontradas: " + peliculas.get().size());
//
//        System.out.println("========== FIN TEST 2 ==========");
//    }
//
//    @Test
//    void buscarPorIdConGeneros() {
//        System.out.println("========== INICIO TEST 3 ==========");
//
//        Optional<Pelicula> peliculas = peliculaRepository.buscarPorIdConGeneros(2);
//        System.out.println("Número de películas encontradas: " + peliculas.get().size());
//
//        for (Pelicula pelicula : peliculas.get()) {
//
//            System.out.println("----------");
//            System.out.println("Id: " + pelicula.getId());
//
//            System.out.println("Detalles: " + pelicula.getSinopsis());
//            // Entiendo que del 2º Endpoint, "Detalles" se refiere a los detalles / sinopsis de la película
//
//            System.out.println("Generos: ");
//
//            // Con este bucle he recorrido la tabla de los géneros para que se muestren los nombres en vez simplemente hacer un "peliculas.getGeneros()"
//            // y que no me mostrara el nombre de los Géneros, si no la referencia a la tabla de los géneros (un textaco raro sin sentido)
//            for (Genero genero : pelicula.getGeneros()) {
//                System.out.println("- " + genero.getNombre());
//            }
//
//            System.out.println("----------");
//        }
//
//        System.out.println("========== FIN TEST 3 ==========");
//    }
//
//}