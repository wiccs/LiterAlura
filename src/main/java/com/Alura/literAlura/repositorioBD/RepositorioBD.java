package com.Alura.literAlura.repositorioBD;

import com.Alura.literAlura.modelos.Entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RepositorioBD extends JpaRepository<Libro,Long> {
        Optional<Libro> findByTituloContainsIgnoreCase(String nombreSerie);



    }

