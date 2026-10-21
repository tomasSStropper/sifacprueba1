package sifac.comun.entidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Documento {
    private final int numero;
    private final Cliente cliente;
    private final List<LineaDetalle> detalles;
    private final double impuesto;

    public Documento(int numero, Cliente cliente, double impuesto) {
        if (numero <= 0 || cliente == null) {
            throw new IllegalArgumentException("Los datos del documento no son válidos.");
        }
        validarPorcentaje(impuesto);
        this.numero = numero;
        this.cliente = cliente;
        this.impuesto = impuesto;
        this.detalles = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public List<LineaDetalle> getDetalles() {
        return new ArrayList<>(detalles);
    }

    public void agregarDetalle(LineaDetalle detalle) {
        if (detalle == null) {
            throw new IllegalArgumentException("El detalle es obligatorio.");
        }
        detalles.add(detalle);
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (LineaDetalle detalle : detalles) {
            subtotal += detalle.calcularSubtotal();
        }
        return subtotal;
    }

    protected void validarPorcentaje(double porcentaje) {
        if (!Double.isFinite(porcentaje) || porcentaje < 0 || porcentaje > 100) {
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 100.");
        }
    }

    public abstract double calcularTotal();
}
