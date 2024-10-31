package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;


public class Empresa {
    private String nombre;
    private List<Vehiculo> vehiculos;
    private List<Cliente> clientes;
    private List<Reserva> reservas;
    private List<Empleado> empleados;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.vehiculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.empleados = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void agregarEmpleado(Empleado empleado) {
        if (empleado != null) {
            empleados.add(empleado);
            System.out.println("Empleado agregado: " + empleado.getNombre());
        }
    }
    public boolean empleadoExiste(String nombre, String id, String email) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equals(nombre) && empleado.getId().equals(id) && empleado.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

}
