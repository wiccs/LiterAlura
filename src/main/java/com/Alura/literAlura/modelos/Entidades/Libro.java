package com.Alura.literAlura.modelos.Entidades;

import com.Alura.literAlura.modelos.DatosLibro;
import jakarta.persistence.*;

import java.util.List;

//Esta clase sirve para crear una BD a partir de esta clase usando JPA.
@Entity
//Nombramos nuestra tabla
@Table(name = "libro")
public class Libro {

    //Generamos un id Identity es recomendado para base de datos que usan MYSQL

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, length = 255) // Ejemplo de longitud para título
    private String titulo;


    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @Column(length = 100) // Ejemplo de longitud para lenguajes
    private String lenguajes;

    @Column(columnDefinition = "text") // Ejemplo de longitud para formatos
    private String formatos;

    private int numDescargas;


    public Libro() {
        // Constructor por defecto necesario para JPA
    }

    public Libro(DatosLibro libro, Autor autor) { // Constructor que recibe el autor
        this.autor = autor;
        this.formatos = String.valueOf(libro.getFormatos());
        this.titulo = libro.getTitulo();
        this.numDescargas = libro.getNumDescargas();
        this.lenguajes = String.valueOf(libro.getLenguajes());
    }

    // Getters y setters
}