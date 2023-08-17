package Recursion;

public class DivisionConRestas {

    //Restas sucesivas de forma recursiva
    public static int restasSucesivas(int num1, int num2){
        if (num1 < num2){
            return 0;
        }
        return 1 + restasSucesivas(num1-num2, num2);

    }

    //Restas sucesivas de forma iterativa
    public static float restasSucesivas(float num1, float num2){
        int cociente = 0;
        while(num1>=num2){
            num1 -= num2;
            cociente += 1;
        }
        return cociente;
    }

    public static void main (String[] args){


        // Instancia de la funcion recursiva
        int resultado1 = restasSucesivas(20, 5);

        //Instancia de la funcion iterativa
        int resultado2 = restasSucesivas(20, 5);


        System.out.println(resultado1);
        System.out.println(resultado2);

    }







}
