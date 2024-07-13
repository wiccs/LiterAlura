package com.Alura.literAlura.repositorioBD;

import com.Alura.literAlura.modelos.Entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RepositorioBD extends JpaRepository<Libro,Long> {





    }

