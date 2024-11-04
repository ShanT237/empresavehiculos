package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.controller.InterfazEmpleadoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import co.edu.uniquindio.poo.App;

public class InterfazEmpleadoViewController {
    private App app;
    private InterfazEmpleadoController empleadoController;

    @FXML
    private Button ingresarButton;
    @FXML
    private TextField ingresarNombre;
    @FXML
    private TextField ingresarID;
    @FXML
    private TextField ingresarEmail;
    @FXML
    private Label error;

    public void setApp(App app) {
        this.app = app;
        this.empleadoController = new InterfazEmpleadoController(App.empresa);
    }

    @FXML
    void initialize() {
        error.setVisible(false);
        ingresarButton.setOnAction(this::handleIngresarButton);
    }
    private void handleIngresarButton(ActionEvent event) {
        String nombre = ingresarNombre.getText();
        String id = ingresarID.getText();
        String email = ingresarEmail.getText();
        App.setEmpleadoIdActual(id);
        
        if (nombre.isEmpty() || id.isEmpty() || email.isEmpty()) {
            error.setText("Todos los campos son obligatorios");
            error.setVisible(true);
            return;
        }
    
        error.setVisible(false);
        
        boolean existe = empleadoController.verificarEmpleado(nombre, id, email);
        if (existe) {
            app.openPrimaryView(nombre); 
        } else {
            error.setText("Empleado no encontrado");
            error.setVisible(true);
        }
    }
    
}
