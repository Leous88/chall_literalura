package com.Leo.Biblioteca.Principal;

import com.Leo.Biblioteca.Modelo.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    private static final String API_URL = "https://gutendex.com/books/";

    public Libro buscarLibroPorTitulo(String titulo) {
        try {
            String url = API_URL + "?search=" + titulo.replace(" ", "%20");
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class);

            // Procesar JSON con Jackson
            var jsonNode = new com.fasterxml.jackson.databind.ObjectMapper().readTree(response);
            var primerResultado = jsonNode.get("results").get(0);

            String tituloLibro = primerResultado.get("title").asText();
            String autor = primerResultado.get("authors").get(0).get("name").asText();
            String idioma = primerResultado.get("languages").get(0).asText();
            int descargas = primerResultado.get("download_count").asInt();

            Libro libro = new Libro(tituloLibro, autor, idioma, descargas);

            // Guardar libro en la base de datos
            return libroRepository.save(libro);
        } catch (Exception e) {
            System.out.println("Error al buscar el libro: " + e.getMessage());
            return null;
        }
    }

    public List<Libro> listarTodosLosLibros() {
        return libroRepository.findAll();
    }

    public List<Libro> listarLibrosPorIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }
}
