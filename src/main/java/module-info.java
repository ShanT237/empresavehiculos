module co.edu.uniquindio.poo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens co.edu.uniquindio.poo.viewController to javafx.fxml; // Esta línea permite el acceso a tu controlador.
    exports co.edu.uniquindio.poo; // Asegúrate de exportar también el paquete principal si es necesario.
}