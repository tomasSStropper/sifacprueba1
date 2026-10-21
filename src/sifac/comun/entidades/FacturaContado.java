package sifac.comun.entidades;

public class FacturaContado extends Documento {
    private final double descuento;

    public FacturaContado(int numero, Cliente cliente, double impuesto, double descuento) {
        super(numero, cliente, impuesto);
        validarPorcentaje(descuento);
        this.descuento = descuento;
    }

    @Override
    public double calcularTotal() {
        double monto = calcularSubtotal() * (1 - descuento / 100);
        return monto * (1 + getImpuesto() / 100);
    }
}
