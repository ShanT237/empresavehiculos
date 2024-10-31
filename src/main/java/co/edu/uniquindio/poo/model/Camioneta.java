package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Camioneta extends Vehiculo{
     private double capacidadCarga;
     private double porcentajeExtra;

    public Camioneta(String matricula, String marca, String modelo, int anioFabricacion, double capacidadCarga) {
        super(matricula, marca, modelo, anioFabricacion);
        this.capacidadCarga = capacidadCarga;
        this.porcentajeExtra = 0.05;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public double calcularCosto(int dias) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularCosto'");
    }


    
}
