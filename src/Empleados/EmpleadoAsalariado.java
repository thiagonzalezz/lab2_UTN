package Empleados;

public class EmpleadoAsalariado extends Empleado implements Impuesto {


    public EmpleadoAsalariado() {
    }

    public EmpleadoAsalariado(String nombre, int id, double sueldoBase) {
        super(nombre, id, sueldoBase);
    }

    @Override
    public double calcularSueldo() {
        return this.sueldoBase;
    }

    @Override
    public double calcularImpuesto() {
        // 10% de impuestos
        return calcularSueldo()*0.1;
    }
}
