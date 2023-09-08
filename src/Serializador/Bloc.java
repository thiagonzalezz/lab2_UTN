import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Bloc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el texto: ");
        String texto = scanner.nextLine();
        Serializador serializador = new Serializador();
        serializador.serializar(texto);
        String textoDeserializado = serializador.deserializar();
        System.out.println("Texto deserializado: ");
        System.out.println(textoDeserializado);
    }
}

class Serializador {
    private static final String NOMBRE_ARCHIVO = "bloc.txt"; // Nombre del archivo

    public void serializar(String texto) {
        try {
            // Crear un flujo de salida para escribir en un archivo llamado "bloc.txt" en modo append con codificación UTF-8
            FileOutputStream archivoSalida = new FileOutputStream(NOMBRE_ARCHIVO, true);
            OutputStreamWriter writer = new OutputStreamWriter(archivoSalida, StandardCharsets.UTF_8);
            // Escribir el texto en el archivo con codificación UTF-8
            writer.write(texto);
            writer.write(System.lineSeparator()); // Agregar un salto de línea después del texto
            // Importante: cerrar el flujo de salida para liberar recursos
            writer.close();
        } catch (Exception e) {
            e.printStackTrace(); // En caso de error, imprimir información de la excepción
        }
    }

    public String deserializar() {
        StringBuilder texto = new StringBuilder();
        try {
            // Abrir un flujo de entrada para leer desde el archivo "bloc.txt" con codificación UTF-8
            FileInputStream archivoEntrada = new FileInputStream(NOMBRE_ARCHIVO);
            InputStreamReader reader = new InputStreamReader(archivoEntrada, StandardCharsets.UTF_8);

            int c;
            while ((c = reader.read()) != -1) {
                texto.append((char) c);
            }

            // Importante: cerrar el flujo de entrada para liberar recursos
            reader.close();
        } catch (Exception e) {
            e.printStackTrace(); // En caso de error, imprimir información de la excepción
        }
        return texto.toString();
    }
}
