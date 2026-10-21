package prueba1.colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PruebaIndice {

    public static void main(String[] args) {
        List<DocumentoIndice> documentos = new ArrayList<>();
        documentos.add(new DocumentoIndice("FC-1007", 48500));
        documentos.add(new DocumentoIndice("FCR-1003", 126000));
        documentos.add(new DocumentoIndice("NC-1001", 18750));
        documentos.add(new DocumentoIndice("FC-1002", 215300));

        Collections.sort(documentos);
        System.out.println("Orden natural: " + unir(documentos));

        int encontrado = Collections.binarySearch(documentos, new DocumentoIndice("FC-1007", 0));
        System.out.println("binarySearch FC-1007 = " + encontrado);

        int resultado = Collections.binarySearch(documentos, new DocumentoIndice("FC-1005", 0));
        System.out.println("binarySearch FC-1005 = " + resultado);

        if (resultado < 0) {
            int posicion = -resultado - 1;
            System.out.println("Posicion de insercion = " + posicion);
            documentos.add(posicion, new DocumentoIndice("FC-1005", 31200));
        }
        System.out.println("Con la insercion: " + unir(documentos));

        Comparator<DocumentoIndice> porTotalDescendente =
                Comparator.comparingDouble(DocumentoIndice::getTotal).reversed();
        Collections.sort(documentos, porTotalDescendente);
        System.out.println("Por total descendente: " + unir(documentos));

        // Antes de volver a buscar por codigo hay que ordenar otra vez por el orden
        // natural con Collections.sort(documentos). binarySearch solo funciona si la
        // lista esta ordenada por el mismo criterio con el que se busca, y ahora
        // esta ordenada por total, asi que el resultado no seria confiable.
    }

    private static String unir(List<DocumentoIndice> documentos) {
        StringBuilder texto = new StringBuilder();
        for (int i = 0; i < documentos.size(); i++) {
            if (i > 0) {
                texto.append(", ");
            }
            texto.append(documentos.get(i).getCodigo());
        }
        return texto.toString();
    }
}
