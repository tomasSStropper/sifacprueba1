package prueba1.entidades;

public abstract class Documento {
    protected static final double IMPUESTO = 1.13;

    private final String codigo;
    private final double subtotal;

    public Documento(String codigo, double subtotal) {
        this.codigo = codigo;
        this.subtotal = subtotal;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public abstract String getTipo();

    public abstract double calcularTotal();
}
