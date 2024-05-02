package guia.impresoras.impresoras.implementations;

import guia.impresoras.documentos.DocumentoImprimible;
import guia.impresoras.impresoras.interfaces.Impresora;


public class ImpresoraLaser implements Impresora <DocumentoImprimible> {

    @Override
    public void imprimir(DocumentoImprimible content) {
        System.out.println("=".repeat(100));
        System.out.printf(">> Iniciando Impresora de Laser para imprimir %s%n.", content.getName());
        System.out.printf(">> Imprimiendo documento con contenido: %s%n", content.getContent());
        System.out.println(">> Archivo impreso correctamente con tecnología láser.");
        System.out.println("=".repeat(100));
    }
    
}