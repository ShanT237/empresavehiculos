package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;


import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;
import co.edu.uniquindio.poo.viewController.GestionReservaViewController;
import co.edu.uniquindio.poo.viewController.InterfazEmpleadoViewController;
import co.edu.uniquindio.poo.viewController.PrimaryViewController;
import co.edu.uniquindio.poo.App;

/**
 * JavaFX App
 */
public class App extends Application {
    /*
     * Nombre del empleado
     */
    private static String empleadoIdActual;

    public static void setEmpleadoIdActual(String id) {
        empleadoIdActual = id;
    }

    public static String getEmpleadoIdActual() {
        return empleadoIdActual;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    private Stage primaryStage;
    public static Empresa empresa = new Empresa("Mi Empresa");

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Empresa Alquiler");

        inicializarData();
        openInterfazEmpleado();
    }

    public static void main(String[] args) {
        launch();
    }

    /*
     * Datos iniciales
     */
    private void inicializarData() {
        empresa.agregarEmpleado(new Empleado("Melinda", "001", "melinda.com"));
        empresa.agregarEmpleado(new Empleado("Michael", "004", "michael.com"));
        empresa.agregarEmpleado(new Empleado("Mateo", "003", "mateo.com"));
        empresa.agregarEmpleado(new Empleado("Santi", "007", "shant.com"));

        empresa.agregarVehiculo(new Auto("A1", "Toyota", "Corolla", 2018, 4));
        empresa.agregarVehiculo(new Auto("A2", "Honda", "Civic", 2020, 4));
        empresa.agregarVehiculo(new Auto("A3", "Ford", "Focus", 2019, 5));
        empresa.agregarVehiculo(new Auto("A4", "Chevrolet", "Malibu", 2017, 4));
        empresa.agregarVehiculo(new Auto("A5", "Nissan", "Altima", 2021, 5));
        empresa.agregarVehiculo(new Auto("A6", "Hyundai", "Elantra", 2016, 4));
        empresa.agregarVehiculo(new Auto("A7", "Mazda", "3", 2019, 5));
        empresa.agregarVehiculo(new Auto("A8", "Volkswagen", "Jetta", 2022, 4));
        empresa.agregarVehiculo(new Auto("A9", "Subaru", "Impreza", 2018, 5));
        empresa.agregarVehiculo(new Auto("A10", "Kia", "Forte", 2020, 4));

        empresa.agregarVehiculo(new Moto("M1", "Yamaha", "R1", 2021, true));
        empresa.agregarVehiculo(new Moto("M2", "Kawasaki", "Ninja", 2020, false));
        empresa.agregarVehiculo(new Moto("M3", "Honda", "CBR", 2019, true));
        empresa.agregarVehiculo(new Moto("M4", "Suzuki", "GSX", 2022, false));
        empresa.agregarVehiculo(new Moto("M5", "Ducati", "Panigale", 2021, true));
        empresa.agregarVehiculo(new Moto("M6", "BMW", "S1000RR", 2018, false));
        empresa.agregarVehiculo(new Moto("M7", "Aprilia", "RSV4", 2022, true));
        empresa.agregarVehiculo(new Moto("M8", "Triumph", "Street Triple", 2020, false));
        empresa.agregarVehiculo(new Moto("M9", "Harley-Davidson", "Sportster", 2021, true));
        empresa.agregarVehiculo(new Moto("M10", "Indian", "Scout", 2019, false));

        empresa.agregarVehiculo(new Camioneta("C1", "Ford", "F-150", 2021, 1200.0));
        empresa.agregarVehiculo(new Camioneta("C2", "Chevrolet", "Silverado", 2020, 1500.0));
        empresa.agregarVehiculo(new Camioneta("C3", "Ram", "1500", 2019, 1400.0));
        empresa.agregarVehiculo(new Camioneta("C4", "GMC", "Sierra", 2022, 1600.0));
        empresa.agregarVehiculo(new Camioneta("C5", "Nissan", "Titan", 2018, 1300.0));
        empresa.agregarVehiculo(new Camioneta("C6", "Toyota", "Tundra", 2021, 1250.0));
        empresa.agregarVehiculo(new Camioneta("C7", "Honda", "Ridgeline", 2020, 1100.0));
        empresa.agregarVehiculo(new Camioneta("C8", "Hyundai", "Santa Cruz", 2022, 1000.0));
        empresa.agregarVehiculo(new Camioneta("C9", "Jeep", "Gladiator", 2021, 1350.0));
        empresa.agregarVehiculo(new Camioneta("C10", "Mazda", "BT-50", 2019, 1200.0));

        empresa.agregarCliente(new Cliente("Carlos Gomez", "C001", "carlos.gomez@example.com"));
        empresa.agregarCliente(new Cliente("Laura Martinez", "C002", "laura.martinez@example.com"));
        empresa.agregarCliente(new Cliente("Luis Rodriguez", "C003", "luis.rodriguez@example.com"));
        empresa.agregarCliente(new Cliente("Ana Perez", "C004", "ana.perez@example.com"));
        empresa.agregarCliente(new Cliente("Jose Hernandez", "C005", "jose.hernandez@example.com"));
        empresa.agregarCliente(new Cliente("Marta Diaz", "C006", "marta.diaz@example.com"));
        empresa.agregarCliente(new Cliente("Diego Torres", "C007", "diego.torres@example.com"));
        empresa.agregarCliente(new Cliente("Elena Castillo", "C008", "elena.castillo@example.com"));
        empresa.agregarCliente(new Cliente("Manuel Garcia", "C009", "manuel.garcia@example.com"));
        empresa.agregarCliente(new Cliente("Rosa Morales", "C010", "rosa.morales@example.com"));
        empresa.agregarCliente(new Cliente("Pablo Ruiz", "C011", "pablo.ruiz@example.com"));
        empresa.agregarCliente(new Cliente("Sara Lopez", "C012", "sara.lopez@example.com"));

        Cliente cliente1 = empresa.getClientes().get(0);
        Cliente cliente2 = empresa.getClientes().get(1);
        Vehiculo vehiculo1 = empresa.getVehiculos().get(0);
        Vehiculo vehiculo2 = empresa.getVehiculos().get(1);
        Empleado empleado1 = empresa.getEmpleados().get(0);
        Empleado empleado2 = empresa.getEmpleados().get(1);

        Reserva reserva1 = new Reserva(cliente1, vehiculo1, LocalDate.now(), LocalDate.now().plusDays(7), empleado1);
        reserva1.setCodigo("R001");

        Reserva reserva2 = new Reserva(cliente2, vehiculo2, LocalDate.now(), LocalDate.now().plusDays(10), empleado2);
        reserva2.setCodigo("R002");

        empresa.agregarReserva(reserva1);
        empresa.agregarReserva(reserva2);

        empresa.mostrarReservas();

    }

    /*
     * Metodo para abrir la interfaz empleado
     */
    public void openInterfazEmpleado() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("InterfazEmpleado.fxml"));
            Pane root = loader.load();

            InterfazEmpleadoViewController controller = loader.getController();
            controller.setApp(this);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Metodo para abrir la ventana principal
     */
    public void openPrimaryView(String nombreEmpleado) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Primary.fxml"));
            Pane rootLayout = loader.load();

            PrimaryViewController primaryController = loader.getController();
            primaryController.setApp(this);
            primaryController.setNombreEmpleado(nombreEmpleado);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openGestionReserva() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("GestionReserva.fxml"));
            Pane root = loader.load();

            GestionReservaViewController gestionReservaController = loader.getController();
            gestionReservaController.setApp(this);
            gestionReservaController.setEmpresa(this.empresa);
            primaryStage.setResizable(true);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
