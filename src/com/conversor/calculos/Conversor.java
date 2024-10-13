package com.conversor.calculos;

import com.conversor.modelos.TasaCambio;

/*Contiene la lógica para convertir la cantidad de dinero entre dos monedas.*/
public class Conversor {

    public double convertir(double cantidad, String desde, String hacia) throws Exception{
        APIClient apiClient = new APIClient();
        TasaCambio tasaCambio = apiClient.obtenerTasaCambio(desde);


        /*Multiplica la cantidad () por la tasa de cambio actual para realizar la conversión.*/
        double tasa = tasaCambio.getConversionRates().get(hacia);
        return cantidad * tasa;
    }
}
