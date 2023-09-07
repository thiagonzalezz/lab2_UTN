package buffers;

import java.io.File;
import java.io.FileReader;

public class Entrada {
    public static void main(String[] args) {
        try {
            FileReader entrada = new FileReader("C:\\Users\\Usuario\\Downloads\\thiago_gonzalez\\LaboratorioII\\src\\buffers\\archivo.txt");
            int caracter = entrada.read();
            char letra = (char) caracter;

            while (caracter != -1) {
                System.out.print(letra);
                caracter = entrada.read();
                letra = (char) caracter;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}