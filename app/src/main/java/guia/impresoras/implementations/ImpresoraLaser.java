package guia.impresoras.implementations;

import guia.impresoras.interfaces.Impresora;


public class ImpresoraLaser implements Impresora {

    @Override
    public void imprimir(String content) {
        System.out.println("=".repeat(30));
        System.out.println(">> Iniciando Impresora Laser...");
        System.out.printf(">> Imprimiendo documento con contenido: %s%n", content);
        System.out.println(">> Archivo impreso correctamente con tecnología láser.");
        System.out.println("=".repeat(30));
    }
    
}