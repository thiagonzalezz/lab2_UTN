package Empleados;


import java.util.ArrayList;
import java.util.List;

public class GestorEmpleados {
    List<Empleado> empleados = new ArrayList<Empleado>();

    public void agregarEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
    }

    public void modificarEmpleado(int id, String nombre, double sueldo, int nuevoID) {
        for (Empleado emp : empleados) {
            if (emp.id == id) {
                emp.nombre = nombre;
                emp.sueldoBase = sueldo;
                emp.id = nuevoID;
            }
        }
    }
    public void eliminarEmpleado(int id) {
        for (Empleado emp : empleados) {
            if (emp.id == id) {
                this.empleados.remove(emp);
            }
        }
    }


}

