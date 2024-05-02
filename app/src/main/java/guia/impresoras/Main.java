
package guia.impresoras;

import guia.impresoras.documentos.DocumentoImprimible;
import guia.impresoras.documentos.DocumentoPDF;
import guia.impresoras.impresoras.implementations.ImpresoraLaser;
import guia.impresoras.impresoras.implementations.ImpresoraPDF;
import guia.impresoras.impresoras.implementations.ImpresoraTinta;

public class Main {

    public static void main(String[] args) {
        DocumentoPDF pdf = new DocumentoPDF("DocPdf", "ESTO ES UN PDF", 12, "/path");
        DocumentoImprimible documento = new DocumentoImprimible("Nomina", "Nomina de empleados");
        // Prueba de la impresora PDF
        ImpresoraPDF impresoraPDF = new ImpresoraPDF();
        System.out.println("Impresión con la Impresora PDF:");
        impresoraPDF.imprimir(pdf);
        System.out.println();

        // Prueba de la impresora de Tinta
        ImpresoraTinta impresoraTinta = new ImpresoraTinta();
        System.out.println("Impresión con la Impresora de Tinta:");
        impresoraTinta.imprimir(documento);
        System.out.println();

        // Prueba de la impresora Láser
        ImpresoraLaser impresoraLaser = new ImpresoraLaser();
        System.out.println("Impresión con la Impresora Láser:");
        impresoraLaser.imprimir(documento);
    }
}