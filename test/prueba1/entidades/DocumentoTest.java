package prueba1.entidades;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DocumentoTest {

    @Test
    public void facturaContadoConSubtotal10000() {
        // Preparar
        Documento contado = new FacturaContado("FC-001", 10000);

        // Ejecutar
        double total = contado.calcularTotal();

        // Verificar
        assertEquals(10735.00, total, 0.01);
    }

    @Test
    public void notaCreditoConSubtotal10000() {
        // Preparar
        Documento nota = new NotaCredito("NC-003", 10000);

        // Ejecutar
        double total = nota.calcularTotal();

        // Verificar
        assertEquals(-11300.00, total, 0.01);
    }
}
