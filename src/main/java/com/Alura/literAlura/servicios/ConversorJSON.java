package com.Alura.literAlura.servicios;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConversorJSON {
    //objectMapper es un metodo de jackson para convertir json a tipo java.
    private ObjectMapper objectMapper = new ObjectMapper();

    //Este Metodo es generico, permite usar cualquier tipo de clase
    public <T> T convertirDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json,clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
