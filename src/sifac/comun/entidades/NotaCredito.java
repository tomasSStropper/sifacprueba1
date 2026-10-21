package sifac.comun.entidades;

public class NotaCredito extends Documento {
    private final double descuento;

    public NotaCredito(int numero, Cliente cliente, double impuesto, double descuento) {
        super(numero, cliente, impuesto);
        validarPorcentaje(descuento);
        this.descuento = descuento;
    }

    @Override
    public double calcularTotal() {
        double monto = calcularSubtotal() * (1 - descuento / 100);
        return -monto * (1 + getImpuesto() / 100);
    }
}
