package co.edu.uniquindio.poo.model;

public class Moto extends Vehiculo {
    private boolean esAutomatica;
    private double tarifaAdicional;

    public Moto(String matricula, String marca, String modelo, int anioFabricacion, boolean esAutomatica) {
        super(matricula, marca, modelo, anioFabricacion);
        this.esAutomatica = esAutomatica;
        this.tarifaAdicional = 10.00;
    }

    @Override
    public double calcularCosto(int dias) {
        double costo = 0;
        if (esAutomatica) {
            costo = dias * (tarifaAdicional + getTarifaBase());

        } else {
            costo = dias * getTarifaBase();

        }
        return costo;
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
    public String toString() {
        return "Moto: Es Automatica: " + esAutomatica + ", Tarifa Adicional: " + tarifaAdicional + super.toString()
                + ".";
    }

}
