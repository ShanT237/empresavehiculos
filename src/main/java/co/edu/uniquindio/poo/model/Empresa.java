package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private List<Vehiculo> vehiculos;
    private List<Cliente> clientes;
    private List<Reserva> reservas;
    private List<Empleado> empleados;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.vehiculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.empleados = new ArrayList<>();
    }

    public void eliminarReserva(String codigo) {
        reservas.removeIf(reserva -> reserva.getCodigo().equals(codigo));
    }

    public void crearReserva(String codigo, String clienteID, String vehiculoMatricula, LocalDate fechaInicio, LocalDate fechaFin, String empleadoId) {
        if (verificarReserva(codigo)) {
            System.out.println("Ya existe una reserva con el código: " + codigo);
            return;
        }

        Cliente cliente = buscarClientePorID(clienteID);
        Empleado empleado = buscarEmpleadoPorId(empleadoId);
        Vehiculo vehiculo = buscarVehiculoPorMatricula(vehiculoMatricula);

        if (cliente == null) {
            System.out.println("Cliente no encontrado con ID: " + clienteID);
            return;
        }
        if (vehiculo == null) {
            System.out.println("Vehículo no encontrado con matrícula: " + vehiculoMatricula);
            return;
        }

        Reserva nuevaReserva = new Reserva(cliente, vehiculo, fechaInicio, fechaFin, empleado);
        nuevaReserva.setCodigo(codigo);
        agregarReserva(nuevaReserva);
    }

    public void actualizarReserva(String codigo, String clienteID, String vehiculoMatricula, LocalDate fechaInicio, LocalDate fechaFin, String empleadoId) {
        Reserva reservaExistente = buscarReserva(codigo);

        if (reservaExistente == null) {
            System.out.println("No se encontró ninguna reserva con el código: " + codigo);
            return;
        }

        Cliente cliente = buscarClientePorID(clienteID);
        Empleado empleado = buscarEmpleadoPorId(empleadoId);
        Vehiculo vehiculo = buscarVehiculoPorMatricula(vehiculoMatricula);

        if (cliente == null) {
            System.out.println("Cliente no encontrado con ID: " + clienteID);
            return;
        }
        if (vehiculo == null) {
            System.out.println("Vehículo no encontrado con matrícula: " + vehiculoMatricula);
            return;
        }

        reservaExistente.setCliente(cliente);
        reservaExistente.setVehiculo(vehiculo);
        reservaExistente.setFechaInicio(fechaInicio);
        reservaExistente.setFechaFin(fechaFin);
        reservaExistente.setEmpleadoAcargo(empleado);
    }

    public Reserva buscarReserva(String codigo) {
        for (Reserva reserva : reservas) {
            if (reserva.getCodigo().equals(codigo)) {
                return reserva;
            }
        }
        return null;
    }

    public Cliente buscarClientePorID(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public Vehiculo buscarVehiculoPorMatricula(String matricula) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        return null;
    }

    public Empleado buscarEmpleadoPorId(String id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId().equals(id)) {
                return empleado;
            }
        }
        System.out.println("No se pudo encontrar el empleado");
        return null;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null && !verificarVehiculo(vehiculo)) {
            vehiculos.add(vehiculo);
            System.out.println("Vehículo registrado exitosamente");
        } else {
            System.out.println("No se pudo agregar el vehículo");
        }
    }

    public boolean verificarVehiculo(Vehiculo vehiculo) {
        for (Vehiculo v : vehiculos) {
            if (v.getMatricula().equals(vehiculo.getMatricula())) {
                return true;
            }
        }
        return false;
    }

    public void agregarCliente(Cliente cliente) {
        if (cliente != null && !verificarCliente(cliente)) {
            clientes.add(cliente);
            System.out.println("El cliente fue agregado de forma exitosa");
        } else {
            System.out.println("El cliente no se pudo agregar");
        }
    }

    public boolean verificarCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getId().equals(cliente.getId())) {
                return true;
            }
        }
        return false;
    }

    public void agregarReserva(Reserva reserva) {
        if (reserva != null && !verificarReserva(reserva.getCodigo())) {
            reservas.add(reserva);
            if (reserva.getEmpleadoAcargo() != null) {
                reserva.getEmpleadoAcargo().agregarReserva(reserva);
            }
            System.out.println("Reserva creada exitosamente");
        } else {
            System.out.println("La reserva no se pudo registrar");
        }
    }

    public boolean verificarReserva(String codigo) {
        for (Reserva r : reservas) {
            if (r.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public void agregarEmpleado(Empleado empleado) {
        if (empleado != null && !verificarEmpleado(empleado)) {
            empleados.add(empleado);
            System.out.println("Empleado agregado: " + empleado.getNombre());
        } else {
            System.out.println("No se pudo agregar el empleado");
        }
    }

    public boolean verificarEmpleado(Empleado empleado) {
        for (Empleado e : empleados) {
            if (e.getId().equals(empleado.getId())) {
                return true;
            }
        }
        return false;
    }

    public boolean empleadoExiste(String nombre, String id, String email) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equals(nombre) && empleado.getId().equals(id)
                    && empleado.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }



    public void mostrarReservas() {
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Empresa: Nombre " + nombre + ", Vehículos " + vehiculos + ", Clientes " + clientes + ", Reservas " + reservas + ", Empleados " + empleados + ".";
    }
}
