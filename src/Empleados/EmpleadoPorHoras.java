package Empleados;

public class EmpleadoPorHoras extends Empleado implements Impuesto {

    private int horasTrabajadas;

    public EmpleadoPorHoras() {
    }

    public EmpleadoPorHoras(String nombre, int id, double sueldoBase, int horasTrabajadas) {
        super(nombre, id, sueldoBase);
        this.horasTrabajadas = horasTrabajadas;
    }


    @Override
    public double calcularSueldo() {
        return this.sueldoBase*this.horasTrabajadas;
    }

    @Override
    public double calcularImpuesto() {
        // 10% de impuestos
        return calcularSueldo()*0.1;
    }
}
