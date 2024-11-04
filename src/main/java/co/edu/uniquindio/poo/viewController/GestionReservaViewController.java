package co.edu.uniquindio.poo.viewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;

public class GestionReservaViewController {

    private App app;
    private Empresa empresa;
    private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    private ObservableList<Vehiculo> listaVehiculos = FXCollections.observableArrayList();
    private ObservableList<Reserva> listaReservas = FXCollections.observableArrayList();
    private Cliente selectedCliente;
    private Vehiculo selectedVehiculo;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label mostrarID;

    @FXML
    private Button volver;

    @FXML
    private Label motrarMatricula;

    @FXML
    private Button actualizarReservaButton;

    @FXML
    private TextField codigo;

    @FXML
    private Button crearResevaButton;

    @FXML
    private Button eliminarButton;

    @FXML
    private TableView<Cliente> clienteTabla;

    @FXML
    private TableColumn<Cliente, String> idSeleccionar;

    @FXML
    private TableColumn<Cliente, String> nombreSeleccionar;

    @FXML
    private TableColumn<Cliente, String> emailSeleccionar;

    @FXML
    private TableView<Vehiculo> tablaVehiculo;

    @FXML
    private TableColumn<Vehiculo, String> matriculaSeleccionar;

    @FXML
    private TableColumn<Vehiculo, String> marcaSeleccionar;

    @FXML
    private TableColumn<Vehiculo, String> modeloSeleccionar;

    @FXML
    private TableColumn<Vehiculo, String> tipoSeleccionar;

    @FXML
    private TableView<Reserva> tablaReservas;

    @FXML
    private TableColumn<Reserva, String> reservaColumnaCodigo;

    @FXML
    private TableColumn<Reserva, String> reservaColumnaCosto;

    @FXML
    private TableColumn<Reserva, String> reservaColumnaEmpleado;

    @FXML
    private TableColumn<Reserva, String> reservaColumnaFechaFinal;

    @FXML
    private TableColumn<Reserva, String> reservaColumnaFechaInicio;

    @FXML
    private TableColumn<Reserva, String> reservaColumnaId;

    @FXML
    private TableColumn<Reserva, String> reservaColumnaMatricula;

    @FXML
    private TableColumn<Reserva, String> reservaColumnaModelo;

    @FXML
    private TableColumn<Reserva, String> reservaColumnaNombre;

    public void setApp(App app) {
        this.app = app;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
        obtenerDatos();
    }

    public void volver() {
        if (app != null) {
            app.openPrimaryView("¿Qué más deseas hacer?");
        }
    }

    @FXML
    void initialize() {
        initDataBinding();
        listenerSelection();
        listenerTablaReservas();
    }

    private void initDataBinding() {

        idSeleccionar.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombreSeleccionar.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        emailSeleccionar.setCellValueFactory(new PropertyValueFactory<>("email"));

        matriculaSeleccionar.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        marcaSeleccionar.setCellValueFactory(new PropertyValueFactory<>("marca"));
        modeloSeleccionar.setCellValueFactory(new PropertyValueFactory<>("modelo"));

        tipoSeleccionar.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getClass().getSimpleName()));

        reservaColumnaId.setCellValueFactory(cellData -> {
            Reserva reserva = cellData.getValue();
            return new SimpleStringProperty(reserva.getCliente().getId());
        });

        reservaColumnaCodigo.setCellValueFactory(cellData -> {
            Reserva reserva = cellData.getValue();
            return new SimpleStringProperty(reserva.getCodigo());
        });

        reservaColumnaCosto.setCellValueFactory(cellData -> {
            Reserva reserva = cellData.getValue();
            return new SimpleStringProperty(String.valueOf(reserva.getCostoTotal()));
        });

        reservaColumnaEmpleado.setCellValueFactory(cellData -> {
            Reserva reserva = cellData.getValue();
            String nombreEmpleado = (reserva.getEmpleadoAcargo() != null) ? reserva.getEmpleadoAcargo().getNombre()
                    : "";
            return new SimpleStringProperty(nombreEmpleado);
        });

        reservaColumnaFechaInicio.setCellValueFactory(cellData -> {
            Reserva reserva = cellData.getValue();
            return new SimpleStringProperty(reserva.getFechaInicio().toString());
        });

        reservaColumnaFechaFinal.setCellValueFactory(cellData -> {
            Reserva reserva = cellData.getValue();
            return new SimpleStringProperty(reserva.getFechaFin().toString());
        });

        reservaColumnaMatricula.setCellValueFactory(cellData -> {
            Reserva reserva = cellData.getValue();
            String matricula = (reserva.getVehiculo() != null) ? reserva.getVehiculo().getMatricula() : "";
            return new SimpleStringProperty(matricula);
        });

        reservaColumnaModelo.setCellValueFactory(cellData -> {
            Reserva reserva = cellData.getValue();
            String modelo = (reserva.getVehiculo() != null) ? reserva.getVehiculo().getModelo() : "";
            return new SimpleStringProperty(modelo);
        });

        reservaColumnaNombre.setCellValueFactory(cellData -> {
            Reserva reserva = cellData.getValue();
            String nombreCliente = (reserva.getCliente() != null) ? reserva.getCliente().getNombre() : "";
            return new SimpleStringProperty(nombreCliente);
        });
    }

    private void obtenerDatos() {
        listaClientes.addAll(empresa.getClientes());
        listaVehiculos.addAll(empresa.getVehiculos());
        listaReservas.clear();
        listaReservas.addAll(empresa.getReservas());

        clienteTabla.setItems(listaClientes);
        tablaVehiculo.setItems(listaVehiculos);
        tablaReservas.setItems(listaReservas);
    }

    private void listenerTablaReservas() {
        tablaReservas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                mostrarID.setText(newSelection.getCliente().getId());
                motrarMatricula.setText(newSelection.getVehiculo().getMatricula());
                codigo.setText(newSelection.getCodigo());
            } else {
                limpiarCampos();
            }
        });
    }

    private void listenerSelection() {
        clienteTabla.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCliente = newSelection;
            mostrarInformacionCliente(selectedCliente);
        });

        tablaVehiculo.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedVehiculo = newSelection;
            mostrarInformacionVehiculo(selectedVehiculo);
        });
    }

    private void mostrarInformacionCliente(Cliente cliente) {
        if (cliente != null) {
            mostrarID.setText(cliente.getId());
        } else {
            mostrarID.setText("");
        }
    }

    private void mostrarInformacionVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            motrarMatricula.setText(vehiculo.getMatricula());
        } else {
            motrarMatricula.setText("");
        }
    }

    @FXML
    void crearReserva() {
        String codigoReserva = codigo.getText();
        String clienteID = mostrarID.getText();
        String vehiculoMatricula = motrarMatricula.getText();

        LocalDate fechaInicio = LocalDate.now();
        LocalDate fechaFin = fechaInicio.plusDays(5);
        String idEmpleado = App.getEmpleadoIdActual();

        if (codigoReserva != null && clienteID != null && vehiculoMatricula != null) {
            empresa.crearReserva(codigoReserva, clienteID, vehiculoMatricula, fechaInicio, fechaFin, idEmpleado);
            obtenerDatos();
            limpiarCampos();

        } else {
            System.out.println("Por favor, seleccione un cliente y un vehículo, y proporcione un código.");
        }
    }

    @FXML
    void actualizarReserva() {
        String codigoReserva = codigo.getText();
        String clienteID = mostrarID.getText();
        String vehiculoMatricula = motrarMatricula.getText();

        LocalDate fechaInicio = LocalDate.now();
        LocalDate fechaFin = fechaInicio.plusDays(5);
        String idEmpleado = App.getEmpleadoIdActual();

        if (codigoReserva != null && clienteID != null && vehiculoMatricula != null) {
            empresa.actualizarReserva(codigoReserva, clienteID, vehiculoMatricula, fechaInicio, fechaFin, idEmpleado);
            obtenerDatos();
            limpiarCampos();

        } else {
            System.out.println("Por favor, seleccione un cliente y un vehículo, y proporcione un código.");
        }
    }

    private void limpiarCampos() {
        mostrarID.setText("");
        motrarMatricula.setText("");
        codigo.setText("");
    }


    @FXML
    void eliminarReserva() {

        Reserva reservaSeleccionada = tablaReservas.getSelectionModel().getSelectedItem();
        if (reservaSeleccionada != null) {

            empresa.eliminarReserva(reservaSeleccionada.getCodigo());
            obtenerDatos();
        } else {
            System.out.println("Seleccione una reserva para eliminar.");
        }
    }
}
