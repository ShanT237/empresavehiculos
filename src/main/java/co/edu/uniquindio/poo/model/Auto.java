package co.edu.uniquindio.poo.model;


public class Auto extends Vehiculo {

    private int numeroPuertas;

    public Auto(String matricula, String marca, String modelo, int anioFabricacion, int numeroPuertas) {
        super(matricula, marca, modelo, anioFabricacion);
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public double calcularCosto(int dias) {
        double costo = 0;
        costo = dias * getTarifaBase();
        return costo;

    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public String toString() {
        return "Auto: Numero Puertas " + numeroPuertas + super.toString() + ".";
    }

    

}
