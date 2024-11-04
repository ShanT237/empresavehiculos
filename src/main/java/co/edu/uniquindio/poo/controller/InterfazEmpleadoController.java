package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Empresa;

public class InterfazEmpleadoController {
    private Empresa empresa;

    public InterfazEmpleadoController(Empresa empresa) {
        this.empresa = empresa;
    }

    public boolean verificarEmpleado(String nombre, String id, String email) {

        if (nombre == null || nombre.isEmpty() || id == null || id.isEmpty() || email == null || email.isEmpty()) {
            System.out.println("Todos los campos son obligatorios.");
            return false;
        }

        boolean existe = empresa.empleadoExiste(nombre, id, email);
        if (existe) {
            System.out.println("Empleado verificado exitosamente: " + nombre);
        } else {
            System.out.println("Empleado no encontrado en la empresa.");
        }

        return existe;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

}
