package com.Alura.literAlura.principal;

import com.Alura.literAlura.servicios.ConexionApi;
import com.Alura.literAlura.ui.Menu;

import java.util.Scanner;

public class Principal {
    //**Atributos**
    String URL_API;
    // datos estaticos de Api:
    private final String URL_BASE = "https://gutendex.com/books?"; //esto es una constante :/


    Scanner entrada = new Scanner(System.in);
    Menu mostrar = new Menu();
    ConexionApi conectarApi = new ConexionApi();

   public void iniciar(){
       mostrar.MostrarMenu();

       switch (mostrar.getEntradaUsuario()){
           case 1:
            buscarLibro();
               break;
       }
   }

   //Metodos:



    private void buscarLibro(){

        System.out.println("Ingrese el nombre del libro a buscar");
        String nombreLibro = entrada.nextLine();
        //Usamos .replace para remplazar espacios por el separador URL %20 codificado
        URL_API = URL_BASE + "search=" + nombreLibro.replace(" ","%20");

        System.out.println("La url de la solicitud es: " + URL_API);

        //Recuerda cuando una funcion retorna un valor hay que almacenarlo en una variable para mostarlo:
         var json = conectarApi.obtenerDatos(URL_API);
        System.out.println("Libros:" + json);


    }

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.iniciar();}


}
