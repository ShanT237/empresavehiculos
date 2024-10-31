package co.edu.uniquindio.poo.model;
import java.time.LocalDate;

public class Reserva {
    private Cliente cliente;
    private Vehiculo vehiculo;
    private String fechaInicio;
    private String fechaFin;
    private double costoTotal;
    private Empleado empleadoAcargo;

    public Reserva(Cliente cliente, Vehiculo vehiculo, String fechaInicio, String fechaFin, Empleado empleadoAcargo) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costoTotal = calcularCosto();
        this.empleadoAcargo = empleadoAcargo;
    }

    private double calcularCosto() {
        int dias = calcularDias(); 
        return vehiculo.calcularCosto(dias);
    }

    private int calcularDias() {

        return 5; 
    }
}

