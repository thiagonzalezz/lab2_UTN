package Recursion;

public class sumatoriaRecursiva {
    public static void main (String[] args){
        // Implementacion del ejercicio 2: sumatoria recursiva
        int numero1 = suma(7);
        int numero2 = suma(10);
        int numero3 = suma(15);
        System.out.println("Resultado de la prueba 1 del ejercicio dos (suma recursiva): " + numero1);
        System.out.println("Resultado de la prueba 2 del ejercicio dos (suma recursiva): " + numero2);
        System.out.println("Resultado de la prueba 3 del ejercicio dos (suma recursiva): " + numero3);
    }
    public static int suma(int num){
        if (num==1){
            return 1;
        }
        return num+=(suma(num-1));
    }
}