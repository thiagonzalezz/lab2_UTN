package Recursion;

public class factorialConSobrecarga {
    // Factorial utilizando recursion
    public static int factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }
    // Factorial utilizando iteracion
    public static float factorial(float num){
        float resultado = 1;
        for (int i = 1; i <= num; i++){
            resultado *= i;
        }
        return resultado;
    }
    public static void main(String[] args){
        int pruebaRecursiva1 = factorial(4);
        int pruebaRecursiva2 = factorial(5);
        int pruebaRecursiva3 = factorial(10);
        float pruebaIterativa1 = factorial(4);
        float pruebaIterativa2 = factorial(5);
        float pruebaIterativa3 = factorial(10);
        System.out.println("Resultado de factorial de 4 con recursion: " + pruebaRecursiva1);
        System.out.println("Resultado de factorial de 4 con iteracion: " + pruebaIterativa1);
        System.out.println("Resultado de factorial de 5 con recursion: " + pruebaRecursiva2);
        System.out.println("Resultado de factorial de 5 con iteracion: " + pruebaIterativa2);
        System.out.println("Resultado de factorial de 10 con recursion: " + pruebaRecursiva3);
        System.out.println("Resultado de factorial de 10 con iteracion: " + pruebaIterativa3);
    }
}