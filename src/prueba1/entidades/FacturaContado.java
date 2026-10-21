package prueba1.entidades;

public class FacturaContado extends Documento {
    private static final double DESCUENTO = 0.95;

    public FacturaContado(String codigo, double subtotal) {
        super(codigo, subtotal);
    }

    @Override
    public String getTipo() {
        return "Contado";
    }

    @Override
    public double calcularTotal() {
        return getSubtotal() * IMPUESTO * DESCUENTO;
    }
}
