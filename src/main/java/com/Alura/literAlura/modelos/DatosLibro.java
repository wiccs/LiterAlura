package com.Alura.literAlura.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatosLibro {

    @JsonProperty("title")
    private String titulo;

    @JsonProperty("authors")
    private List<Map<String, String>> autores;



    @JsonProperty("languages")
    private List<String> lenguajes;

    @JsonProperty("formats")
    private Map<String, String> formatos;

    @JsonProperty("download_count")
    private Integer numDescargas;

    // Constructor vacío requerido por Jackson.
    public DatosLibro() {
    }

    // Getters y setters (puedes generarlos automáticamente en tu IDE).

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Map<String, String>> getAutores() {
        return autores;
    }

    public void setAutores(List<Map<String, String>> autores) {
        this.autores = autores;
    }



    public Map<String, String> getFormatos() {
        return formatos;
    }

    public void setFormatos(Map<String, String> formatos) {
        this.formatos = formatos;
    }

    public Integer getNumDescargas() {
        return numDescargas;
    }

    public void setNumDescargas(Integer numDescargas) {
        this.numDescargas = numDescargas;
    }

    public List<String> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(List<String> lenguajes) {
        this.lenguajes = lenguajes;
    }

    // Método toString para imprimir los detalles del libro.
    @Override
    public String toString() {
        return "DatosLibro{" +
                "titulo='" + titulo + '\'' +
                ", autores=" + autores +
                ", formatos=" + formatos +
                ", numDescargas=" + numDescargas +
                '}';
    }
}
