package com.Alura.literAlura.ui;

import java.util.Scanner;

public class Menu {
    int entradaUsuario;

    //Este metodo mostrara el menu al usuario y podremos acceder a su eleccion.
    public void MostrarMenu(){

        Scanner teclado = new Scanner(System.in);

        System.out.println("""
                Bienbenido, este programa le proporciona informacion sobre libros
                Seleccione la operacion a realizar:
                
                1 ---> Busqueda de libros
              
                """);
         this.entradaUsuario= teclado.nextInt();
    }

    public int getEntradaUsuario() {
        return entradaUsuario;
    }

}
