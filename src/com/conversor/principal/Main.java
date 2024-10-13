package com.conversor.principal;

import com.conversor.calculos.Conversor;
import com.conversor.modelos.Moneda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Moneda dolar = new Moneda("Dólar", "USD");
        Moneda pesoArgentino = new Moneda("Peso Argentino", "ARS");
        Moneda realBrasileno = new Moneda("Real Brasileño", "BRL");
        Moneda pesoColombiano = new Moneda("Peso Colombiano", "COP");

        boolean continuar = true;

        while (continuar){ /*continuará ejecutándose hasta que el usuario elija la opción de salir*/

            System.out.println("********************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Peso argentino => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.println("********************************");
            System.out.print("Elija una opción válida: ");

            int opcion = scanner.nextInt(); /*El usuario ingresa la opción 1. El programa lo guarda en la variable opcion.*/

            if (opcion == 7){
                continuar = false;
                System.out.println("Saliendo...");
                break;
            }

            Moneda monedaOrigen = null;
            Moneda monedaDestino = null;

            switch (opcion){
                case 1:
                    monedaOrigen = dolar;
                    monedaDestino = pesoArgentino;
                    break;
                case 2:
                    monedaOrigen = pesoArgentino;
                    monedaDestino = dolar;
                    break;

                case 3:
                    monedaOrigen = pesoArgentino;
                    monedaDestino = realBrasileno;
                    break;

                case 4:
                    monedaOrigen = realBrasileno;
                    monedaDestino = dolar;
                    break;

                case 5:
                    monedaOrigen = dolar;
                    monedaDestino = pesoColombiano;
                    break;

                case 6:
                    monedaOrigen = pesoColombiano;
                    monedaDestino = dolar;
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    continue;
            }
            System.out.println("Ingresa el valor que deseas convertir: ");
            double cantidad = scanner.nextDouble();

            try {
                Conversor conversor = new Conversor(); /*El programa crea un nuevo objeto Conversor*/
                //llama al método convertir()   === Este método realiza la conversión de moneda usando las tasas de cambio obtenidas a través de una API. Internamente
                double resultado = conversor.convertir(cantidad, monedaOrigen.getCodigo(), monedaDestino.getCodigo());

                System.out.println("El valor " + cantidad + " [" + monedaOrigen.getCodigo() + "] corresponde al valor final de =>> "
                        + resultado + " [" + monedaDestino.getCodigo() + "]");
            } catch (Exception e) {
                System.out.println("Ocurrió un error durante la conversión: " + e.getMessage());
            }
        }
    }
}