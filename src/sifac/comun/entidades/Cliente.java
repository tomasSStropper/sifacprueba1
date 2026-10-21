package sifac.comun.entidades;

public class Cliente {
    private final String cedula;
    private final String nombre;

    public Cliente(String cedula, String nombre) {
        if (cedula == null || cedula.trim().isEmpty()
                || nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("La cédula y el nombre son obligatorios.");
        }
        this.cedula = cedula.trim();
        this.nombre = nombre.trim();
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return cedula + " - " + nombre;
    }
}
