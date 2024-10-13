package com.conversor.modelos;

import java.util.Map;

/*Define la estructura de los datos obtenidos de la API (las tasas de cambio).*/
public class TasaCambio {

    private String base_code;
    private Map<String, Double> conversion_rates;

    public String getBaseCode() {
        return base_code;
    }

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }
}
