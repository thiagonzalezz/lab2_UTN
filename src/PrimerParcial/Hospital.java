package PrimerParcial;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        Gestor gestor = new Gestor();
        Doctor doctorUno = new Doctor("Juan Lopez", 34187952, "03/08/1981", "Cardiologia");
        Doctor doctorDos = new Doctor("Miguel Esperanza", 31256882, "02/01/1979", "Neurologia");
        Doctor doctorTres = new Doctor("Eustaquio Gimenez", 29532455, "25/07/1991", "Pediatria");
        Doctor doctorCuatro = new Doctor("Pedro Martinez", 40101232, "12/11/1992", "Cirugia");
        Doctor doctorCinco = new Doctor("Rodrigo Garnacho", 32682158, "30/03/1961", "Enfermeria");
        gestor.agregarDoctor(doctorUno);
        gestor.agregarDoctor(doctorDos);
        gestor.agregarDoctor(doctorTres);
        gestor.agregarDoctor(doctorCuatro);
        gestor.agregarDoctor(doctorCinco);
        do{
            System.out.println("Hospital Julio C. Perrando - Av. 9 de Julio 1100 · 0362 444-2399");
            System.out.println("Menú:");
            System.out.println("1. Listar Doctores.");
            System.out.println("2. Registrar un nuevo paciente.");
            System.out.println("3. Actualizar información personal de un paciente.");
            System.out.println("4. Consultar el historial médico de un paciente.");
            System.out.println("5. Nuevo historial para un paciente.");
            System.out.println("6. Guardar Historial de pacientes en archivo");
            System.out.println("7. Cargar Historial de pacientes desde archivo");
            System.out.println("8. Salir.");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    gestor.mostrarDoctores();
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del paciente que desea agregar: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el dni: ");
                    int dni = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese fecha de nacimiento con el siguiente formato: dd/MM/yyyy");
                    String fecha;
                    fecha = scanner.nextLine();
                    System.out.println("Ingrese su numero de telefono: ");
                    int telefono = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese su tipo de sangre: ");
                    int sangre = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese su historial medico con el siguiente formato: dd/MM/yyyy - observaciones");
                    String historial = scanner.nextLine();
                    Paciente paciente = new Paciente(nombre, dni, fecha, telefono, sangre, historial);
                    gestor.agregarPaciente(paciente);
                    break;
                case 3:
                    System.out.println("Ingrese el DNI del paciente al cual desea actualizar su informacion: ");
                    int dniActualizar = scanner.nextInt();
                    scanner.next();
                    System.out.println("Ingrese el nuevo nombre del paciente: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.println("Ingrese el nuevo telefono del paciente: ");
                    int nuevoTelefono = scanner.nextInt();
                    gestor.actualizarPaciente(dniActualizar, nuevoNombre, nuevoTelefono);
                    break;
                case 4:
                    System.out.println("Ingrese el dni del paciente que desea ver su historial medico: ");
                    int dniHistorial = scanner.nextInt();
                    gestor.mostrarHistorial(dniHistorial);
                    break;
                case 5:
                    System.out.println("Ingrese el dni del paciente al cual desea agregar un nuevo historial: ");
                    int dniNuevoHistorial = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el historial que desea agregar con el siguiente formato: dd/MM/yyyy - observaciones");
                    String texto = scanner.nextLine();
                    gestor.agregarHistorial(dniNuevoHistorial, texto);
                    break;
                case 6:
                    gestor.guardarPacientesEnArchivo("datos.txt");
                    break;
                case 7:
                    gestor = Gestor.cargarReservasDesdeArchivo("datos.txt");
                    if (gestor != null) {
                        System.out.println("Pacientes cargados desde archivo exitosamente.");
                    } else {
                        System.out.println("Error al cargar los pacientes desde el archivo.");
                    }
                    break;
                case 8:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, elija una opcion valida");
            }
        } while(opcion != 8);
        scanner.close();
    }
}
class Persona implements Serializable{
    private String nombre;
    private int dni;
    private String  fechaDeNacimiento;
    public Persona() {
    }
    public Persona(String nombre, int dni, String fechaDeNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
}
class Doctor extends Persona{
    private String especialidad;
    public Doctor() {
    }
    public Doctor(String nombre, int dni, String fechaDeNacimiento, String especialidad) {
        super(nombre, dni, fechaDeNacimiento);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
interface Informacion{
    void verHistorialDeEventos();
}
class Paciente extends Persona implements Informacion, Serializable{
    private int nroTelefono;
    private int tipoSangre;
    private String historialMedico;
    private ArrayList<String> historial = new ArrayList <>();
    public Paciente() {
    }
    public Paciente(String nombre, int dni, String fechaDeNacimiento, int nroTelefono, int tipoSangre, String historialMedico) {
        super(nombre, dni, fechaDeNacimiento);
        this.nroTelefono = nroTelefono;
        this.tipoSangre = tipoSangre;
        this.historialMedico = historialMedico;
        this.historial.add(historialMedico);
    }

    public int getNroTelefono() {
        return nroTelefono;
    }
    public void setNroTelefono(int nroTelefono) {
        this.nroTelefono = nroTelefono;
    }
    public int getTipoSangre() {
        return tipoSangre;
    }
    public void setTipoSangre(int tipoSangre) {
        this.tipoSangre = tipoSangre;
    }
    public String getHistorialMedico() {
        return historialMedico;
    }
    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }

    @Override
    public void verHistorialDeEventos() {
        for(String histo: this.historial){
            System.out.println(histo);
        }
    }
    public void agregarHistorial(String texto){
        this.historial.add(texto);
    }


}
class Gestor implements Serializable{
    private List<Doctor> doctores;
    private List<Paciente> pacientes;
    public Gestor() {
        this.doctores = new ArrayList <>();
        this.pacientes = new ArrayList <>();
    }
    public void agregarDoctor(Doctor doctor){
        doctores.add(doctor);
    }
    public void mostrarDoctores(){
        System.out.println("Doctores: ");
        for(Doctor doctor: doctores){
            System.out.println(doctor.getNombre());
        }
    }
    public void agregarPaciente(Paciente paciente){
        pacientes.add(paciente);
    }
    public void actualizarPaciente(int dni, String nuevoNombre, int nuevoTelefono){
        for (Paciente paciente: pacientes){
            if (paciente.getDni() == dni){
                paciente.setNombre(nuevoNombre);
                paciente.setNroTelefono(nuevoTelefono);
            } else {
                System.out.println("Error, no se encontro a un paciente con ese DNI");
            }
        }
    }
    public void mostrarHistorial(int dni){
        System.out.println("HISTORIAL MÉDICO: ");
        for(Paciente paciente: pacientes){
            if (paciente.getDni() == dni){
                paciente.verHistorialDeEventos();
            } else {
                System.out.println("No se encontro un paciente con ese DNI");
            }
        }
    }
    public void agregarHistorial(int dni, String texto){
        for (Paciente paciente: pacientes){
            if (paciente.getDni() == dni){
                paciente.agregarHistorial(texto);
            } else {
                System.out.println("No se encontro un paciente con ese DNI");
            }
        }
    }

    public void guardarPacientesEnArchivo(String nombreArchivo) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            salida.writeObject(this);
            System.out.println("Pacientes guardados en archivo exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar los pacientes en el archivo: " + e.getMessage());
        }
    }
    public static Gestor cargarReservasDesdeArchivo(String nombreArchivo) {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (Gestor) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los pacientes desde el archivo: " + e.getMessage());
            return null;
        }
    }
}