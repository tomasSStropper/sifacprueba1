package sifac.comun.entidades;

public class Producto {
    private final String codigo;
    private final String nombre;
    private final double precio;

    public Producto(String codigo, String nombre, double precio) {
        if (codigo == null || codigo.trim().isEmpty()
                || nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El código y el nombre son obligatorios.");
        }
        if (!Double.isFinite(precio) || precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.codigo = codigo.trim();
        this.nombre = nombre.trim();
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
