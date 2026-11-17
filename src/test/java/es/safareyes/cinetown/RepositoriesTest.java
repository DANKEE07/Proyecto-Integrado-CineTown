package es.safareyes.cinetown;

import es.safareyes.cinetown.dtos.RecaudacionDTO;
import es.safareyes.cinetown.modelos.*;
import es.safareyes.cinetown.proyecciones.GeneroCarteleraProyeccion;
import es.safareyes.cinetown.repositorios.*;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class RepositoriesTest {

    @Autowired
    private IPeliculaRepository peliculaRepository;

    @Autowired
    private IGeneroRepository generoRepository;

    @Autowired
    private ISesionRepository sesionRepository;

    @Autowired
    private ISalaRepository salaRepository;

    @Autowired
    private ICompraRepository compraRepository;


    @Test
    void probarConexion() {

        System.out.println("========== INICIO TEST ==========");

        long cantidad = peliculaRepository.count();

        System.out.println("Número de películas: " + cantidad);

        System.out.println("========== FIN TEST ==========");
    }


    // GET /api/v1/peliculas
    @Test
    void listarPeliculas() {

        System.out.println("========== INICIO TEST 1 ==========");

        Page<Pelicula> peliculas = peliculaRepository.findAll(
                PageRequest.of(0, 10, Sort.by("id").ascending())
        );

        System.out.println("Número de películas: " + peliculas.getTotalElements());

        System.out.println("Número de páginas: " + peliculas.getTotalPages());

        for (Pelicula pelicula : peliculas.getContent()) {

            System.out.println("--------------------");
            System.out.println("ID: " + pelicula.getId());
            System.out.println("Título: " + pelicula.getTitulo());
            System.out.println("Año: " + pelicula.getAnio());
            System.out.println("Duración: " + pelicula.getDuracion());

        }

        System.out.println("========== FIN TEST 1 ==========");
    }


    // GET /api/v1/peliculas/{id}
    @Test
    @Transactional
    void buscarPeliculaPorIdConGeneros() {

        System.out.println("========== INICIO TEST 2 ==========");

        Optional<Pelicula> resultado = peliculaRepository.buscarPorIdConGeneros(2);

        if (resultado.isPresent()) {

            Pelicula pelicula = resultado.get();

            System.out.println("ID: " + pelicula.getId());
            System.out.println("Título: " + pelicula.getTitulo());
            System.out.println("Sinopsis: " + pelicula.getSinopsis());

            System.out.println("Géneros:");

            for (Genero genero : pelicula.getGeneros()) {
                System.out.println("- " + genero.getNombre());
            }

        } else {

            System.out.println("No se ha encontrado la película.");

        }

        System.out.println("========== FIN TEST 2 ==========");
    }


    // GET /api/v1/generos
    @Test
    void consultarGenerosConPeliculasEnCartelera() {

        System.out.println("========== INICIO TEST 3 ==========");

        List<GeneroCarteleraProyeccion> generos =
                generoRepository.contarGenerosConPeliculasEnCartelera();

        System.out.println("Número de géneros: " + generos.size());

        for (GeneroCarteleraProyeccion genero : generos) {

            System.out.println("--------------------");
            System.out.println("ID: " + genero.getId());
            System.out.println("Nombre: " + genero.getNombre());
            System.out.println("Películas en cartelera: " + genero.getNumeroPeliculasEnCartelera());

        }

        System.out.println("========== FIN TEST 3 ==========");
    }



    // GET /api/v1/salas
    @Test
    void consultarSalasYCapacidades() {

        System.out.println("========== INICIO TEST 4 ==========");

        List<Sala> salas = salaRepository.findAll();

        System.out.println("Número de salas: " + salas.size());

        for (Sala sala : salas) {

            System.out.println("--------------------");
            System.out.println("ID: " + sala.getId());
            System.out.println("Número de sala: " + sala.getNumero());
            System.out.println("Capacidad: " + sala.getCapacidad());

        }

        System.out.println("========== FIN TEST 4 ==========");
    }


    // GET /api/v1/sesiones?fecha={fecha}&peliculaId={id}
    @Test
    void consultarSesiones() {
        System.out.println("========== INICIO TEST 5 ==========");

        // También puedo usar el LocalDate.now() o cualquier otro LocalDate
        List<Sesion> sesiones = sesionRepository.buscarSesiones(LocalDate.of(2026, 11, 22), 2);

        System.out.println("Número de sesiones: " + sesiones.size());


        for (Sesion sesion : sesiones) {
            System.out.println(sesion);
        }


        System.out.println("========== FIN TEST 5 ==========");
    }




    // GET /api/v1/sesiones/{id}
    @Test
    void consultarSesionesPorId() {

        System.out.println("========== INICIO TEST 6 ==========");

        String mensajeError = "No se encontró la sesión con el ID proporcionado.";

        Sesion sesion = sesionRepository.findById(1).orElseThrow(() -> new RuntimeException(mensajeError));
        // No he querido usar aquí las Excepciones porque para ese entonces no las tenía, y a parte, para
        // tener separado la parte de Postman de la parte del Test

        System.out.println(sesion);

        System.out.println("========== FIN TEST 6 ==========");
    }


    // GET /api/v1/compras/{codigo}
    @Test
    void buscarCompraPorCodigo() {

        System.out.println("========== INICIO TEST 7 ==========");

        List<Compra> compras = compraRepository.findAll();


        if (!compras.isEmpty()) {

            String codigo = compras.get(0).getCodigo();
            Optional<Compra> resultado = compraRepository.findByCodigo(codigo);

            if (resultado.isPresent()) {

                Compra compra = resultado.get();

                System.out.println("Compra encontrada:");
                System.out.println("Código: " + compra.getCodigo());
                System.out.println(compra);

            } else {

                System.out.println("No se ha encontrado la compra");
            }

        } else {

            System.out.println("No hay compras registradas");
        }

        System.out.println("========== FIN TEST 7 ==========");
    }


    // GET /api/v1/compras

    @Test
    void listarCompras() {

        System.out.println("========== INICIO TEST 8 ==========");

        List<Compra> compras = compraRepository.findAll();

        System.out.println("Número de compras: " + compras.size());


        for (Compra compra : compras) {

            System.out.println("--------------------");
            System.out.println("Código: " + compra.getCodigo());
            System.out.println(compra);

        }

        System.out.println("========== FIN TEST 8 ==========");

    }




    // GET /api/v1/peliculas/{id}/recaudacion

    @Test
    void consultarRecaudacionPelicula() {

        System.out.println("========== INICIO TEST 9 ==========");

        RecaudacionDTO recaudacion = peliculaRepository.obtenerRecaudacion(1);

        System.out.println("Recaudación de la película: " + recaudacion);

        System.out.println("========== FIN TEST 9 ==========");

    }














}