package sifac.comun.entidades;

public class FacturaCredito extends Documento {
    private final double recargo;

    public FacturaCredito(int numero, Cliente cliente, double impuesto, double recargo) {
        super(numero, cliente, impuesto);
        validarPorcentaje(recargo);
        this.recargo = recargo;
    }

    @Override
    public double calcularTotal() {
        double monto = calcularSubtotal() * (1 + getImpuesto() / 100);
        return monto * (1 + recargo / 100);
    }
}
