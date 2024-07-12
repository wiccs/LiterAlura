package com.Alura.literAlura.servicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApi {

    //Creamos un metodo que hace una solicitud, usando una URL de la API y reetorna un JSON.
    public String obtenerDatos(String url){
        //Creamos cliente http

//  HttpClient client = HttpClient.newHttpClient();
        //Hay que ser precavido y tratar las redirecciones:
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();



        HttpResponse<String> response = null;


        //Capturamos los posibles errores con un try.
        try {
            //Enviamos la solicitud http y especificamos que queremos una respuesta como string
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            System.err.println("IOException occurred: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException occurred: " + e.getMessage());
            throw new RuntimeException(e);
        }
        //Guardamos la respuesta json en una variable y la retornamos.
        var json = response.body();
        return json;
    }

}
