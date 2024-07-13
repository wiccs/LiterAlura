package com.Alura.literAlura.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class DatosAutor {

        private String autor;
    private String nacimiento;
    private String defuncion;

   public DatosAutor(DatosLibro libro){

       Map<String, String> autorMap = libro.getAutores().get(0);

       this.autor = autorMap.get("name");
       this.nacimiento = autorMap.get("birth_year");
       this.defuncion = autorMap.get("death_year");

   }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getDefuncion() {
        return defuncion;
    }

    public void setDefuncion(String defuncion) {
        this.defuncion = defuncion;
    }
}
