package guia.impresoras.implementations;

import guia.impresoras.interfaces.Impresora;

public class ImpresoraPDF implements Impresora {

    @Override
    public void imprimir(String content) {
        System.out.println("=".repeat(30));
        System.out.println(">> Iniciando Impresora PDF...");
        System.out.printf(">> Imprimiendo archivo PDF con el contenido: %s%n", content);
        System.out.println(">> Archivo generado: pdfMagico.pdf");
        System.out.println("=".repeat(30));
    }
    
}