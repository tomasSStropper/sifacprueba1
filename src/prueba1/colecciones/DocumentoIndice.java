package prueba1.colecciones;

public class DocumentoIndice implements Comparable<DocumentoIndice> {
    private final String codigo;
    private final double total;

    public DocumentoIndice(String codigo, double total) {
        this.codigo = codigo;
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public int compareTo(DocumentoIndice otro) {
        return codigo.compareTo(otro.codigo);
    }

    @Override
    public String toString() {
        return codigo;
    }
}
