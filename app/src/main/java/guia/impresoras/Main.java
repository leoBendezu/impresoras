
package guia.impresoras;

import guia.impresoras.implementations.ImpresoraLaser;
import guia.impresoras.implementations.ImpresoraPDF;
import guia.impresoras.implementations.ImpresoraTinta;
import guia.impresoras.interfaces.Impresora;

public class Main {

    public static void main(String[] args) {
        String documento = "¡Hola, mundo! Este es un documento de prueba.";

        // Prueba de la impresora PDF
        Impresora impresoraPDF = new ImpresoraPDF();
        System.out.println("Impresión con la Impresora PDF:");
        impresoraPDF.imprimir(documento);
        System.out.println();

        // Prueba de la impresora de Tinta
        Impresora impresoraTinta = new ImpresoraTinta();
        System.out.println("Impresión con la Impresora de Tinta:");
        impresoraTinta.imprimir(documento);
        System.out.println();

        // Prueba de la impresora Láser
        Impresora impresoraLaser = new ImpresoraLaser();
        System.out.println("Impresión con la Impresora Láser:");
        impresoraLaser.imprimir(documento);
    }
}