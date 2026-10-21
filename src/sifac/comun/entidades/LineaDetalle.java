package sifac.comun.entidades;

public class LineaDetalle {
    private final Producto producto;
    private final int cantidad;

    public LineaDetalle(Producto producto, int cantidad) {
        if (producto == null || cantidad <= 0) {
            throw new IllegalArgumentException("Seleccione un producto y una cantidad mayor a cero.");
        }
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double calcularSubtotal() {
        return producto.getPrecio() * cantidad;
    }
}
