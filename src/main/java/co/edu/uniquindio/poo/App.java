package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import co.edu.uniquindio.poo.controller.InterfazEmpleadoController;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.viewController.InterfazEmpleadoViewController;
import co.edu.uniquindio.poo.viewController.PrimaryViewController;
import co.edu.uniquindio.poo.App;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage primaryStage;
    public static Empresa empresa = new Empresa("Mi Empresa");

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestión de Empleados");

        inicializarData();
        openInterfazEmpleado(); // Iniciar con la ventana de login
    }

    public static void main(String[] args) {
        launch();
    }

    private void inicializarData() {
        empresa.agregarEmpleado(new Empleado("Juan", "001", "juan@example.com"));
        empresa.agregarEmpleado(new Empleado("Maria", "002", "maria@example.com"));
        empresa.agregarEmpleado(new Empleado("Shant", "007", "shant.com"));
    }

    // Método para abrir la vista de InterfazEmpleado (login)
    public void openInterfazEmpleado() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("InterfazEmpleado.fxml"));
            Pane root = loader.load();

            InterfazEmpleadoViewController controller = loader.getController();
            controller.setApp(this);  // Pasar referencia de App

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para abrir la vista principal después del login
    public void openPrimaryView(String nombreEmpleado) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Primary.fxml"));
            Pane rootLayout = loader.load();

            PrimaryViewController primaryController = loader.getController();
            primaryController.setApp(this); // Pasar referencia de App
            primaryController.setNombreEmpleado(nombreEmpleado);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
