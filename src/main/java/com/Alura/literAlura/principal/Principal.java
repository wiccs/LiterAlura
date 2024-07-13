package com.Alura.literAlura.principal;

import com.Alura.literAlura.modelos.DatosAutor;
import com.Alura.literAlura.modelos.DatosLibro;
import com.Alura.literAlura.modelos.Entidades.Autor;
import com.Alura.literAlura.modelos.Entidades.Libro;
import com.Alura.literAlura.repositorioBD.RepositorioBD;
import com.Alura.literAlura.repositorioBD.RepositorioBD2;
import com.Alura.literAlura.servicios.ConexionApi;
import com.Alura.literAlura.ui.Menu;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    // Atributos
    private String URL_API;
    private final String URL_BASE = "https://gutendex.com/books?"; // Constante para la URL base de la API

    // Objetos a usar
    private final Scanner entrada = new Scanner(System.in);
    private final ConexionApi conectarApi = new ConexionApi();
    private RepositorioBD BD;
    private RepositorioBD2 BD2;

     private final Menu menu = new Menu();


    public Principal(RepositorioBD repository,RepositorioBD2 repository2) {
        this.BD = repository;
        this.BD2 = repository2;
    }

    public void iniciar() {
       menu.MostrarMenu();

        switch (menu.getEntradaUsuario()) {
            case 1:
                buscarLibro();
                break;
            case 2:
                buscarLibro();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }





    private void buscarLibro() {
        entrada.nextLine(); // Consumir el salto de línea

        System.out.println("Ingrese el nombre del libro a buscar:");
        String nombreLibro = entrada.nextLine();
        //Construir Url
        URL_API = URL_BASE + "search=" + nombreLibro.replace(" ", "%20");

        //System.out.println("La URL de la solicitud es: " + URL_API);

        try {
            //Realizamos la solicitud:
            String json = conectarApi.obtenerDatos(URL_API);

            //Convertimos la respuesta json a un árbol de nodos (JsonNode) para trabajar bien:

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);

            //Analizamos si hay un array llamado results y que no este vacio
            if (rootNode.has("results") && rootNode.get("results").isArray() && rootNode.get("results").size() > 0) {
                //Si se cumple entonces lo obtenemos:
                JsonNode primerLibroNode = rootNode.get("results").get(0);

                //Mapeamos el json a nuestra clase java:
                DatosLibro jsonLibro = objectMapper.convertValue(primerLibroNode, DatosLibro.class);
                System.out.println(jsonLibro);

                DatosAutor jsonAutor = new DatosAutor(jsonLibro);
                Autor autor = new Autor(jsonAutor);

                BD2.save(autor);

                //Guardamos en la base de datos:
                Libro libroBD = new Libro(jsonLibro,autor);



                // Guardar el autor en la base de datos

                BD.save(libroBD);


            } else {
                System.out.println("No se encontraron resultados para el libro buscado.");
            }
        } catch (JsonProcessingException e) {
            System.err.println("Error al procesar el JSON: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de entrada/salida al conectar con la API: " + e.getMessage());
        }
    }


}
