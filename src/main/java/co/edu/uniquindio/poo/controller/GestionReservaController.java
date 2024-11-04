package co.edu.uniquindio.poo.controller;

import java.time.LocalDate;
import co.edu.uniquindio.poo.model.Empresa;

public class GestionReservaController {

    private Empresa empresa;

    public GestionReservaController(Empresa empresa) {
        this.empresa = empresa;
    }

    public void crearReserva(String codigo, String clienteID, String vehiculoMatricula, LocalDate fechaInicio, LocalDate fechaFin, String idEmpleado) {
        
        empresa.crearReserva(codigo, clienteID, vehiculoMatricula, fechaInicio, fechaFin, idEmpleado);
    }

    public void actualizarReserva(String codigo, String clienteID, String vehiculoMatricula, LocalDate fechaInicio, LocalDate fechaFin, String idEmpleado) {

        empresa.actualizarReserva(codigo, clienteID, vehiculoMatricula, fechaInicio, fechaFin, idEmpleado);
    }
}