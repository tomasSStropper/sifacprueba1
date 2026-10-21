package prueba1.entidades;

public class FacturaCredito extends Documento {
    private static final double RECARGO = 1.02;

    public FacturaCredito(String codigo, double subtotal) {
        super(codigo, subtotal);
    }

    @Override
    public String getTipo() {
        return "Credito";
    }

    @Override
    public double calcularTotal() {
        return getSubtotal() * IMPUESTO * RECARGO;
    }
}
