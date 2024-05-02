package guia.impresoras.impresoras.implementations;


import guia.impresoras.documentos.DocumentoPDF;
import guia.impresoras.impresoras.interfaces.Impresora;

public class ImpresoraPDF implements Impresora <DocumentoPDF> {

    @Override
    public void imprimir(DocumentoPDF content) {
        System.out.println("=".repeat(100));
        System.out.println(">> Iniciando Impresora PDF...");
        System.out.printf(">> Imprimiendo archivo PDF %s con el contenido: %s%n", content.getName(), content.getContent());
        System.out.printf(">> Archivo generado: %s%s%n", content.getName(), DocumentoPDF.EXTENSION);
        System.out.println("=".repeat(100));
    }
    
}