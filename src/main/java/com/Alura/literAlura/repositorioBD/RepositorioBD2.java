package com.Alura.literAlura.repositorioBD;

import com.Alura.literAlura.modelos.Entidades.Autor;
import com.Alura.literAlura.modelos.Entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RepositorioBD2 extends JpaRepository<Autor,Long> {






    }


