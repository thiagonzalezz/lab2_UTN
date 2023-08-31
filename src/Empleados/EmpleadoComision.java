package Empleados;

public class EmpleadoComision extends Empleado implements Impuesto {

    private double ventasRealizadas;

    public EmpleadoComision() {
    }

    public EmpleadoComision(String nombre, int id, double sueldoBase, double ventasRealizadas) {
        super(nombre, id, sueldoBase);
        this.ventasRealizadas = ventasRealizadas;
    }

    @Override
    public double calcularSueldo() {
        // Suponemos que el porcentaje de comision por ventas es del 30%
        return this.sueldoBase+(0.3 * this.ventasRealizadas);
    }
    @Override
    public double calcularImpuesto() {
        // 10% de impuestos
        return calcularSueldo()*0.1;
    }
}
