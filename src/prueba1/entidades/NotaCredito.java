package prueba1.entidades;

public class NotaCredito extends Documento {

    public NotaCredito(String codigo, double subtotal) {
        super(codigo, subtotal);
    }

    @Override
    public String getTipo() {
        return "Nota";
    }

    @Override
    public double calcularTotal() {
        return -getSubtotal() * IMPUESTO;
    }
}
