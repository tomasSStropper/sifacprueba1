package sifac.caja.ui;

import java.util.Scanner;
import sifac.comun.datos.RepositorioClientesMemoria;
import sifac.comun.entidades.Cliente;
import sifac.comun.entidades.Documento;
import sifac.comun.entidades.LineaDetalle;
import sifac.comun.entidades.Producto;
import sifac.comun.logica.ServicioFacturacion;

public class Principal {
    private final Scanner entrada = new Scanner(System.in);
    private final ServicioFacturacion servicio;
    private final Producto[] productos = {
        new Producto("Producto 1", "Cuaderno", 1500),
        new Producto("Producto 2 ", "Lapicero", 500),
        new Producto("Producto 3", "Carpeta", 1000)
    };

    public Principal(ServicioFacturacion servicio) {
        this.servicio = servicio;
    }

    public static void main(String[] args) {
        ServicioFacturacion servicio = new ServicioFacturacion(new RepositorioClientesMemoria());
        new Principal(servicio).menu();
    }

    private void menu() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("SIFAC");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver clientes");
            System.out.println("3. Crear documento");
            System.out.println("0. Salir");
            try {
                opcion = leerNumero("Opción: ");
                switch (opcion) {
                    case 1:
                        registrarCliente();
                        break;
                    case 2:
                        verClientes();
                        break;
                    case 3:
                        crearDocumento();
                        break;
                    case 0:
                        System.out.println("Hasta luego.");
                        break;
                    default:
                        System.out.println("Opción incorrecta.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void registrarCliente() {
        String cedula = leerTexto("Cédula: ");
        String nombre = leerTexto("Nombre: ");
        servicio.registrarCliente(cedula, nombre);
        System.out.println("Cliente registrado.");
    }

    private void verClientes() {
        if (servicio.listarClientes().isEmpty()) {
            System.out.println("No hay clientes registrados.");
        }
        for (Cliente cliente : servicio.listarClientes()) {
            System.out.println(cliente);
        }
    }

    private void crearDocumento() {
        System.out.println("1. Factura de contado (descuento 5 %)");
        System.out.println("2. Factura de crédito (recargo 2 %)");
        System.out.println("3. Nota de crédito (devolución de contado)");
        int tipo = leerNumero("Tipo: ");
        String cedula = leerTexto("Cédula del cliente: ");
        Documento documento = servicio.crearDocumento(tipo, cedula);
        System.out.println("Impuesto del 13 %");
        boolean terminar = false;
        while (!terminar) {
            mostrarProductos();
            try {
                int opcion = leerNumero("Producto (0 para terminar): ");
                if (opcion == 0) {
                    if (documento.getDetalles().isEmpty()) {
                        System.out.println("Documento cancelado: no tiene productos.");
                        return;
                    }
                    terminar = true;
                } else if (opcion < 1 || opcion > productos.length) {
                    System.out.println("Producto incorrecto.");
                } else {
                    int cantidad = leerNumero("Cantidad: ");
                    servicio.agregarProducto(documento, productos[opcion - 1], cantidad);
                    System.out.println("Producto agregado.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        mostrarDocumento(documento);
    }

    private void mostrarProductos() {
        for (int i = 0; i < productos.length; i++) {
            Producto producto = productos[i];
            System.out.printf("%d. %s - %s - CRC %.2f%n",
                    i + 1, producto.getCodigo(), producto.getNombre(), producto.getPrecio());
        }
    }

    private void mostrarDocumento(Documento documento) {
        System.out.println("\n" + documento.getClass().getSimpleName() + " N.º " + documento.getNumero());
        System.out.println("Cliente: " + documento.getCliente());
        for (LineaDetalle detalle : documento.getDetalles()) {
            System.out.printf("%s x %d = CRC %.2f%n", detalle.getProducto().getNombre(),
                    detalle.getCantidad(), detalle.calcularSubtotal());
        }
        System.out.printf("Subtotal: CRC %.2f%n", documento.calcularSubtotal());
        System.out.printf("Total: CRC %.2f%n", documento.calcularTotal());
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return entrada.nextLine().trim();
    }

    private int leerNumero(String mensaje) {
        try {
            return Integer.parseInt(leerTexto(mensaje));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ingrese un numero entero.");
        }
    }
}
