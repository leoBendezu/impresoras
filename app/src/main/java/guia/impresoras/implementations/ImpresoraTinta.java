package guia.impresoras.implementations;

import guia.impresoras.interfaces.Impresora;

public class ImpresoraTinta implements Impresora {

    @Override
    public void imprimir(String content) {
        System.out.println("=".repeat(30));
        System.out.println(">> Iniciando Impresora de Tinta...");
        System.out.printf(">> Imprimiendo documento con contenido: %s%n", content);
        System.out.println(">> Archivo impreso correctamente con tinta.");
        System.out.println("=".repeat(30));
    }
    
}