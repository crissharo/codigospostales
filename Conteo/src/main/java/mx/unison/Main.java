package mx.unison;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Nueva ruta del archivo
        String archivo = "codigos_postales.csv"; // Ajusta según la ubicación de tu archivo Java

        int conteoUrbanos = 0;
        int conteoRurales = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            // Si el archivo tiene una cabecera, puedes leerla y descartarla aquí
            // br.readLine();

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
