package com.Leo.Biblioteca.Principal;

import com.Leo.Biblioteca.Modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByIdioma(String idioma); // Consulta derivada para buscar libros por idioma
}
