package com.Alura.literAlura.modelos.Entidades;

import com.Alura.literAlura.modelos.DatosAutor;
import com.Alura.literAlura.modelos.DatosLibro;
import jakarta.persistence.*;

import java.util.List;


@Entity
//Nombramos nuestra tabla
    @Table(name = "autor")
    public class Autor {

        //Generamos un id Identity es recomendado para base de datos que usan MYSQL

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;


        private String nombre;


        private String nacimiento;


        private String defuncion;

        //Esta sera mi llave foranea:


    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Libro> libros;

    public Autor() {
        // Constructor por defecto necesario para JPA
    }
        public Autor(DatosAutor autor) {
          this.nombre = autor.getAutor();
          this.nacimiento = autor.getNacimiento();
          this.defuncion = autor.getDefuncion();
        }
}
