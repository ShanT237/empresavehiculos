package co.edu.uniquindio.poo.model;


public class Camioneta extends Vehiculo{
     private double capacidadCarga;
     private double porcentajeExtra;

    public Camioneta(String matricula, String marca, String modelo, int anioFabricacion, double capacidadCarga) {
        super(matricula, marca, modelo, anioFabricacion);
        this.capacidadCarga = capacidadCarga;
        this.porcentajeExtra = 0.05;
    }

    @Override
    public double calcularCosto(int dias) {
        double costo = 0;
        costo = (getTarifaBase() + (capacidadCarga * porcentajeExtra)) * dias;
        return costo;
    
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public double getPorcentajeExtra() {
        return porcentajeExtra;
    }

    public void setPorcentajeExtra(double porcentajeExtra) {
        this.porcentajeExtra = porcentajeExtra;
    }

    @Override
    public String toString() {
        return "Camioneta: Capacidad Carga: " + capacidadCarga + ", Porcentaje Extra " + porcentajeExtra + super.toString() +".";
    }

    


    
}
