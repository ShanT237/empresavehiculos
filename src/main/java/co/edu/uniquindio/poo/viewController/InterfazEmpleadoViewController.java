package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.controller.InterfazEmpleadoController;
import co.edu.uniquindio.poo.model.Empresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
        System.out.println("Botón 'Ingresar' presionado");
        
        String nombre = ingresarNombre.getText();
        String id = ingresarID.getText();
        String email = ingresarEmail.getText();
    
        System.out.println("Nombre: " + nombre + ", ID: " + id + ", Email: " + email);
    
        // Verifica que los campos no estén vacíos
        if (nombre.isEmpty() || id.isEmpty() || email.isEmpty()) {
            error.setText("Todos los campos son obligatorios");
            error.setVisible(true);
            return;
        }
    
        error.setVisible(false);
        
        // Llamar al método para verificar el empleado
        boolean existe = empleadoController.verificarEmpleado(nombre, id, email);
        
        // Si el empleado existe, abrir la vista principal
        if (existe) {
            app.openPrimaryView(nombre); // Abrir la ventana principal usando App
        } else {
            error.setText("Empleado no encontrado");
            error.setVisible(true);
        }
    }
    
}
