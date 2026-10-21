package sifac.comun.datos;

import java.util.List;
import sifac.comun.entidades.Cliente;

public interface RepositorioClientes {
    void guardar(Cliente cliente);
    Cliente buscar(String cedula);
    List<Cliente> listar();
}
