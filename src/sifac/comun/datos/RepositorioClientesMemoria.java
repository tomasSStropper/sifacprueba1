package sifac.comun.datos;

import java.util.ArrayList;
import java.util.List;
import sifac.comun.entidades.Cliente;

public class RepositorioClientesMemoria implements RepositorioClientes {
    private final List<Cliente> clientes = new ArrayList<>();

    @Override
    public void guardar(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente es obligatorio.");
        }
        if (buscar(cliente.getCedula()) != null) {
            throw new IllegalArgumentException("La cédula ya está registrada.");
        }
        clientes.add(cliente);
    }

    @Override
    public Cliente buscar(String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> listar() {
        return new ArrayList<>(clientes);
    }
}
