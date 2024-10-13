package com.conversor.calculos;

import com.conversor.modelos.TasaCambio;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/* Realiza la solicitud a la API de tasas de cambio y obtiene los datos en formato JSON.*/
public class APIClient {

    private static final String API_URL= "https://v6.exchangerate-api.com/v6/5b88415c8e604909a931ca13/latest/";

    public TasaCambio obtenerTasaCambio(String desde) throws Exception {
        String apiUrl = API_URL + desde;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200){
            throw new RuntimeException("HttpResponseCode: " + response.statusCode());
        }
        // Parsear el JSON usando Gson y convertirlo directamente en un objeto TasaCambio
        Gson gson = new Gson();
        TasaCambio tasaCambio = gson.fromJson(response.body(), TasaCambio.class);


        return tasaCambio;
    }

}
