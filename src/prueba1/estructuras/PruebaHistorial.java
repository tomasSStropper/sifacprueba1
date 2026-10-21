package prueba1.estructuras;

public class PruebaHistorial {

    public static void main(String[] args) {
        HistorialDocumento historial = new HistorialDocumento();

        System.out.println("Historial nuevo: contar() = " + historial.contar()
                + "; getEstadoActual() = " + historial.getEstadoActual());

        historial.registrar("EMITIDO");
        historial.registrar("PENDIENTE_ENVIO");
        historial.registrar("ENVIADO");
        System.out.println("registrar EMITIDO, PENDIENTE_ENVIO, ENVIADO");

        System.out.println("contar() = " + historial.contar()
                + "; getEstadoActual() = " + historial.getEstadoActual());

        System.out.println("eliminarPrimero() = " + historial.eliminarPrimero()
                + "; contar() = " + historial.contar());
        System.out.println("eliminarPrimero() = " + historial.eliminarPrimero());
        System.out.println("eliminarPrimero() = " + historial.eliminarPrimero());

        System.out.println("contar() = " + historial.contar()
                + "; getEstadoActual() = " + historial.getEstadoActual());
        System.out.println("eliminarPrimero() = " + historial.eliminarPrimero());
    }
}
