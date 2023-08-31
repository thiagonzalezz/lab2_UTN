package Empleados;

import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        GestorEmpleados gestor = new GestorEmpleados();
        int tipo = 0;
        while (true) {
            System.out.println("1. Agregar empleado\n2. Modificar empleado\n3. Eliminar empleado\n4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Tipos de empleado:\n1. Empleado por horas\n2. Empleado asalariado\n3. Empleado por comision ");
                    System.out.println("Ingrese tipo de empleado: ");
                    tipo = scanner.nextInt();
                    System.out.print("Ingrese nombre del empleado: ");
                    String nombreEmpleado = scanner.next();
                    System.out.print("Ingrese ID del empleado: ");
                    int idEmpleado = scanner.nextInt();
                    System.out.print("Ingrese sueldo base del empleado: ");
                    double sueldoBase = scanner.nextDouble();

                    switch(tipo){
                        case 1:
                            System.out.println("Ingrese las horas trabajadas: ");
                            int horas = scanner.nextInt();
                            EmpleadoPorHoras empHoras = new EmpleadoPorHoras(nombreEmpleado, idEmpleado , sueldoBase, horas);
                            break;
                        case 2:
                            EmpleadoAsalariado empAsal = new EmpleadoAsalariado(nombreEmpleado, idEmpleado , sueldoBase);
                            break;
                        case 3:
                            System.out.println("Ingrese las ventas realizadas: ");
                            double ventas = scanner.nextDouble();
                            EmpleadoComision empCom = new EmpleadoComision(nombreEmpleado, idEmpleado, sueldoBase, ventas);
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Ingrese ID del empleado a editar: ");
                    int idEditar = scanner.nextInt();
                    System.out.print("Ingrese nuevo nombre del empleado: ");
                    String nombreEditar = scanner.next();
                    System.out.print("Ingrese nuevo ID del empleado: ");
                    int nuevoID = scanner.nextInt();
                    System.out.println("Ingrese nuevo sueldo base del empleado: ");
                    double sueldoEditar = scanner.nextDouble();
                    gestor.modificarEmpleado(idEditar, nombreEditar, sueldoEditar, nuevoID);
                    break;
                case 3:
                    System.out.print("Ingrese ID del empleado a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    gestor.eliminarEmpleado(idEliminar);
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        }




    }

}

