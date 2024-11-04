package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PrimaryViewController {
    private App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private Button gestionarAlquiler;

    @FXML
    private Button gestionarClientes;

    @FXML
    private Button gestionarVehiculos;

    @FXML
    private Label nombreEmpleadoPanel;

    @FXML
    void initialize() {
        assert gestionarAlquiler != null
                : "fx:id=\"gestionarAlquiler\" was not injected: check your FXML file 'Primary.fxml'.";
        assert gestionarClientes != null
                : "fx:id=\"gestionarClientes\" was not injected: check your FXML file 'Primary.fxml'.";
        assert gestionarVehiculos != null
                : "fx:id=\"gestionarVehiculos\" was not injected: check your FXML file 'Primary.fxml'.";
        assert nombreEmpleadoPanel != null
                : "fx:id=\"nombreEmpleadoPanel\" was not injected: check your FXML file 'Primary.fxml'.";
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        nombreEmpleadoPanel.setText(nombreEmpleado);
    }

    @FXML
    private void handleGestionarAlquiler() {
        app.openGestionReserva();
    }
}

