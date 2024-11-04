package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String nombre, id, email;
    private List<Reserva> reservas;

    public Empleado(String nombre, String id, String email) {
        this.nombre = nombre;
        this.id = id;
        this.email = email;
        this.reservas = new ArrayList<>();
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Empleado [nombre=" + nombre + ", id=" + id + ", email=" + email + ";";
    }

}
