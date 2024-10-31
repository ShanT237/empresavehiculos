package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Empresa;

public class InterfazEmpleadoController {
    private Empresa empresa;

    public InterfazEmpleadoController(Empresa empresa) {
        this.empresa = empresa;
    }

    public boolean verificarEmpleado(String nombre, String id, String email) {
        // Verificar que los campos no estén vacíos
        if (nombre == null || nombre.isEmpty() || id == null || id.isEmpty() || email == null || email.isEmpty()) {
            System.out.println("Todos los campos son obligatorios.");
            return false; // Retornar false si hay campos vacíos
        }
    
        // Verifica si el empleado existe en la empresa
        boolean existe = empresa.empleadoExiste(nombre, id, email);
        if (existe) {
            System.out.println("Empleado verificado exitosamente: " + nombre);
        } else {
            System.out.println("Empleado no encontrado en la empresa.");
        }
        
        return existe; // Retornar true si el empleado existe, false si no
    }
    
    

    public Empresa getEmpresa() {
        return empresa;
    }
    
}
