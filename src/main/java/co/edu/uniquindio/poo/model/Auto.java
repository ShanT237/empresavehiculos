package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Auto extends Vehiculo {

    private int numeroPuertas;


    public Auto(String matricula, String marca, String modelo, int anioFabricacion, int numeroPuertas) {
        super(matricula, marca, modelo, anioFabricacion);
        this.numeroPuertas = numeroPuertas;
    }

    

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }



    @Override
    public double calcularCosto(int dias) {
        return dias;
        
    }

}
