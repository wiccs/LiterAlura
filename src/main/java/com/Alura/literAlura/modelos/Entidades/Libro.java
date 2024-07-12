package com.Alura.literAlura.modelos.Entidades;

import com.Alura.literAlura.modelos.DatosLibro;
import jakarta.persistence.*;
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

     @Column(columnDefinition = "text") // Campo de texto largo para autores
     private String autores;

     @Column(length = 100) // Ejemplo de longitud para lenguajes
     private String lenguajes;

     @Column(columnDefinition = "text") // Ejemplo de longitud para formatos
     private String formatos;

     private int numDescargas;

     public Libro(DatosLibro libro) {
    this.autores = libro.getAutores().toString();
    this.formatos = String.valueOf(libro.getFormatos());
    this.titulo = libro.getTitulo();
    this.numDescargas = libro.getNumDescargas();
    this.lenguajes = String.valueOf(libro.getLenguajes());
     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getTitulo() {
         return titulo;
     }

     public void setTitulo(String titulo) {
         this.titulo = titulo;
     }

     public String getAutores() {
         return autores;
     }

     public void setAutores(String autores) {
         this.autores = autores;
     }

     public String getLenguajes() {
         return lenguajes;
     }

     public void setLenguajes(String lenguajes) {
         this.lenguajes = lenguajes;
     }

     public String getFormatos() {
         return formatos;
     }

     public void setFormatos(String formatos) {
         this.formatos = formatos;
     }

     public int getNumDescargas() {
         return numDescargas;
     }

     public void setNumDescargas(int numDescargas) {
         this.numDescargas = numDescargas;
     }
 }
