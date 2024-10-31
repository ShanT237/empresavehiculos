package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Moto extends Vehiculo {
    private boolean esAutomatica;
    private double tarifaAdicional;

    public Moto(String matricula, String marca, String modelo, int anioFabricacion, boolean esAutomatica) {
        super(matricula, marca, modelo, anioFabricacion);
        this.esAutomatica = esAutomatica;
        this.tarifaAdicional = 10.00;
    }

    public boolean isEsAutomatica() {
        return esAutomatica;
    }

    public void setEsAutomatica(boolean esAutomatica) {
        this.esAutomatica = esAutomatica;
    }

    public double getTarifaAdicional() {
        return tarifaAdicional;
    }

    public void setTarifaAdicional(double tarifaAdicional) {
        this.tarifaAdicional = tarifaAdicional;
    }

    @Override
    public double calcularCosto(int dias) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularCosto'");
    }

    
    
}
