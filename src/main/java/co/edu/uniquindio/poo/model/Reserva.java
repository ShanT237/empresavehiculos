package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Reserva {
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double costoTotal;
    private Empleado empleadoAcargo;
    private String codigo;

    public Reserva(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin,
            Empleado empleadoAcargo) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costoTotal = calcularCosto();
        this.empleadoAcargo = empleadoAcargo;
    }

    private double calcularCosto() {
        int dias = calcularDias(fechaInicio, fechaFin);
        return vehiculo.calcularCosto(dias);
    }

    private int calcularDias(LocalDate fechaInicio, LocalDate fechaFin) {
        int dias = 0;
        for (LocalDate fechaActual = fechaInicio; fechaActual
                .isBefore(fechaFin); fechaActual = fechaActual.plusDays(1)) {
            dias++;

        }

        return dias;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Empleado getEmpleadoAcargo() {
        return empleadoAcargo;
    }

    public void setEmpleadoAcargo(Empleado empleadoAcargo) {
        this.empleadoAcargo = empleadoAcargo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Reserva: Cliente " + cliente + ", Vehiculo " + vehiculo + ", Fecha Inicio " + fechaInicio
                + ", fecha Fin "
                + fechaFin + ", Costo Total " + costoTotal + ", Empleado Acargo " + empleadoAcargo + ", Codigo "
                + codigo
                + ".";
    }

}
