package co.edu.uniquindio.poo.model;

public class Cliente {
    private String nombre, id, email;

    public Cliente(String nombre, String id, String email) {
        this.nombre = nombre;
        this.id = id;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", id=" + id + ", email=" + email + "]";
    }

    
    
}
