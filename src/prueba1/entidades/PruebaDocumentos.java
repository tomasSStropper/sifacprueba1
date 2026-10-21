package prueba1.entidades;

import java.util.Locale;

public class PruebaDocumentos {

    public static void main(String[] args) {
        Documento[] documentos = {
            new FacturaContado("FC-001", 10000),
            new FacturaCredito("FCR-002", 10000),
            new NotaCredito("NC-003", 10000)
        };

        double cierre = 0;
        for (Documento documento : documentos) {
            double total = documento.calcularTotal();
            System.out.printf(Locale.US, "%-8s%9.2f%n", documento.getTipo() + ":", total);
            cierre += total;
        }
        System.out.printf(Locale.US, "%-8s%9.2f%n", "Cierre:", cierre);
    }
}
