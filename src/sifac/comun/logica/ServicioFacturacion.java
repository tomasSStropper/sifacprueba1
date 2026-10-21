package sifac.comun.logica;

import java.util.List;
import sifac.comun.datos.RepositorioClientes;
import sifac.comun.entidades.Cliente;
import sifac.comun.entidades.Documento;
import sifac.comun.entidades.FacturaContado;
import sifac.comun.entidades.FacturaCredito;
import sifac.comun.entidades.LineaDetalle;
import sifac.comun.entidades.NotaCredito;
import sifac.comun.entidades.Producto;

public class ServicioFacturacion {
    private final RepositorioClientes repositorio;
    private int consecutivo = 1;

    public ServicioFacturacion(RepositorioClientes repositorio) {
        if (repositorio == null) {
            throw new IllegalArgumentException("El repositorio es obligatorio.");
        }
        this.repositorio = repositorio;
    }

    public void registrarCliente(String cedula, String nombre) {
        repositorio.guardar(new Cliente(cedula, nombre));
    }

    public List<Cliente> listarClientes() {
        return repositorio.listar();
    }

    public Documento crearDocumento(int tipo, String cedula) {
        Cliente cliente = repositorio.buscar(cedula);
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no está registrado.");
        }
        Documento documento;
        switch (tipo) {
            case 1:
                documento = new FacturaContado(consecutivo, cliente, 13, 5);
                break;
            case 2:
                documento = new FacturaCredito(consecutivo, cliente, 13, 2);
                break;
            case 3:
                documento = new NotaCredito(consecutivo, cliente, 13, 5);
                break;
            default:
                throw new IllegalArgumentException("El tipo de documento no es válido.");
        }
        consecutivo++;
        return documento;
    }

    public void agregarProducto(Documento documento, Producto producto, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero.");
        }
        if (documento == null || producto == null) {
            throw new IllegalArgumentException("El documento y el producto son obligatorios.");
        }
        documento.agregarDetalle(new LineaDetalle(producto, cantidad));
    }
}
