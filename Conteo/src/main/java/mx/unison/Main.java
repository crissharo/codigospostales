package mx.unison;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String archivo = "codigos_postales.csv";

        int conteoUrbanos = 0;
        int conteoRurales = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;


            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(",");
                if (columnas.length > 2) {
                    String tipo = columnas[2].trim();

                    if (tipo.equalsIgnoreCase("Urbano")) {
                        conteoUrbanos++;
                    } else if (tipo.equalsIgnoreCase("Rural")) {
                        conteoRurales++;
                    }
                }
            }

            System.out.println("Urbanos: " + conteoUrbanos);
            System.out.println("Rurales: " + conteoRurales);

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
