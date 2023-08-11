import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2, num3;
        int mayor, medio, menor;
        mayor = 0;
        medio = 0;
        menor = 0;
        System.out.println("Ingrese el primer numero");
        num1 = scanner.nextInt();
        System.out.println("Ingrese el segundo numero");
        num2 = scanner.nextInt();
        System.out.println("Ingrese el tercer numero");
        num3 = scanner.nextInt();
        if ((num1 > num2) && (num1 > num3)){
            mayor = num1;
            if (num2>num3){
                medio = num2;
                menor = num3;

            } else {
                medio = num3;
                menor = num2;
            }
        } else if ((num2 > num1) && (num2 > num3)){
            mayor = num2;
            if (num1>num3){
                medio = num1;
                menor = num3;
            } else {
                medio = num3;
                menor = num1;
            }
        } else if ((num3 > num2) && (num3> num1)){
            mayor = num3;
            if (num1>num2){
                medio = num1;
                menor = num2;
            } else {
                medio = num2;
                menor = num1;
            }
        }

        System.out.println("EL numero mayor es el numero: "+mayor);
        System.out.println("EL numero mayor es el numero: "+medio);
        System.out.println("EL numero mayor es el numero: "+menor);
    }
}
