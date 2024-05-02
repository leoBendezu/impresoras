
## **Interfaces en Java**

Las interfaces en Java proporcionan un mecanismo para definir un conjunto de métodos que deben ser implementados por cualquier clase que las implemente. A diferencia de las clases abstractas, las interfaces no pueden contener implementaciones de métodos, solo las firmas de los métodos (Aunque versiones mas nuevas de java permiten la utilización de la palabra reservada default permitiendo crear métodos en interfaces).

### **¿Por qué usar interfaces?**

1. **Abstracción y Estandarización**: Las interfaces nos permiten definir un conjunto de comportamientos estándar que las clases concretas pueden implementar, lo que promueve la abstracción y la estandarización del código.
2. **Múltiple herencia**: Como habíamos dicho anteriormente Java no admite la herencia múltiple de clases, pero sí permite que una clase implemente múltiples interfaces. Esto nos brinda la flexibilidad de definir comportamientos comunes para clases que pueden no tener una relación de herencia directa.
3. **Contratos**: Las interfaces definen contratos que las clases deben cumplir. Esto facilita la creación de código modular y favorece el diseño basado en interfaces en lugar de en implementaciones concretas.

### **Declaración de interfaces**

En Java, declaramos una interfaz utilizando la palabra clave **interface**, seguida del nombre de la interfaz y el cuerpo que contiene las firmas de los métodos.

```java

public interface MiInterfaz {
    void metodo1();
    int metodo2(String parametro);
    // Otros métodos...
}

```

### **Implementación de interfaces**

Una clase puede implementar una interfaz utilizando la palabra clave **implements** seguida del nombre de la interfaz. La clase debe proporcionar una implementación para todos los métodos declarados en la interfaz.

```java
public class MiClase implements MiInterfaz {
    @Override
    public void metodo1() {
        // Implementación del método 1
    }

    @Override
    public int metodo2(String parametro) {
        // Implementación del método 2
        return 0;
    }
    // Otros métodos de la clase...
}

```

### Ejemplo de Interfaces: Impresoras.

Tras detectar problemas en el sistema de impresión de documentos en la oficina, se nos ha encomendado la tarea de mejorar la integración con el ERP. Para lograrlo, vamos a implementar un diseño basado en interfaces que permita una gestión más eficiente y flexible de las impresoras y los documentos a imprimir.

Para eso vamos a definir la interfaz Impresora y las clases ImpresoraPDF, ImpresoraTinta, ImpresoraLaser.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/99e88e59-d351-463f-842d-f4980476f694/7c20ef6d-4e1c-44ea-abca-de52b5f83d52/Untitled.png)

```java
public interface Impresora { // 1 
    
    void imprimir(String content); // 2

}
```

1. Podemos ver el uso de la palabra reservada interface.
2. Como se ve, todo método de una interfaz tiene que ser siempre y por defecto publico, por ende no es necesario agregarlo a la firma del método, además podemos ver como carece de cuerpo.

Las implementaciones de dicha interfaz

```java
public class ImpresoraPDF implements Impresora { // 1

    @Override
    public void imprimir(String content) {
        System.out.println("=".repeat(30));
        System.out.println(">> Iniciando Impresora PDF...");
        System.out.printf(">> Imprimiendo archivo PDF con el contenido: %s%n", content);
        System.out.println(">> Archivo generado: pdfMagico.pdf");
        System.out.println("=".repeat(30));
    }
    
}
```

```java
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
```

```java
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
```

Como podemos observar, cada una de las clases utiliza la palabra reservada **`implements`** para indicar que cumple con el contrato definido por la interfaz **`Impresora`**. Además, es importante destacar que la anotación **`@Override`** aparece nuevamente en este contexto, siendo utilizada para indicar que el método está sobrescribiendo una implementación previamente definida en la interfaz.

Si quisiéramos que alguna de estas clases además implemente algún otra interfaz basta con agregarla separada por comas de la siguiente manera

```java
public class ImpreseraPDF implements Impresora, Serializable {

}
```

### Polimorfismo en Interfaces

Veamos un main usando estas clases e interfaz:

```java
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
```

Observamos el polimorfismo de igual manera que en el ejemplo de las herencias. Aunque estamos creando instancias de tipos específicos, las almacenamos en variables del tipo de la interfaz **`Impresora`**. Este enfoque es similar a lo que hicimos anteriormente con las colecciones, donde usábamos una variable del tipo **`List`** (una interfaz), pero creábamos instancias de **`ArrayList`** (una implementación concreta). Esta práctica es beneficiosa, ya que nos permite intercambiar rápidamente el tipo de implementación que estamos usando por otra sin necesidad de cambiar todo el código, dado que nos relacionamos directamente con la interfaz y sus métodos definidos.

**Por ende y como regla general siempre debemos crear las variables del tipo mas especifico es decir la interfaz.**

# Genéricos

Los genéricos en Java permiten crear clases, interfaces y métodos que pueden trabajar con diferentes tipos de datos. Por ejemplo, en el caso de las colecciones, podemos tener una lista que contenga elementos de cualquier tipo, como enteros, cadenas o incluso objetos personalizados, esto podíamos verlo al definir la Lista usando <> e indicando el tipo de dato con el que iba a trabajar la lista.

```java
public class Main {

    public static void main(String[] args) {
        List<Integer> listaEnteros = new ArrayList<>();
        listaEnteros.add(10);
        listaEnteros.add(20);
        listaEnteros.add(30);

        List<String> listaCadenas = new ArrayList<>();
        listaCadenas.add("Hola");
        listaCadenas.add("Mundo");
    }
}
```

En el ejemplo anterior, utilizamos la clase **`List`** parametrizada con el tipo de datos que queremos almacenar en la lista (**`Integer`** para la lista de enteros y **`String`** para la lista de cadenas). Esto nos permite crear listas que contengan elementos de un tipo específico y proporciona comprobaciones de tipos en tiempo de compilación para evitar errores.

## Agregando Genéricos a Impresora.

Ahora, vamos a modificar la interfaz **`Impresora`** para que sea genérica, ya que vamos a introducir clases imprimibles y necesitamos que la interfaz sea flexible en tiempo de ejecución mediante el uso de genéricos.

```java
public interface Impresora<T> { // 1

	void imprimir(T contenido); // 2

}
```

1. Para indicar que nuestra interfaz o clase utiliza algún tipo genérico, agregamos un parámetro de tipo entre **`< >`** después del nombre. Por convención, es común utilizar letras mayúsculas para estos parámetros.
2. Ahora, la firma del método **`imprimir`** recibe un tipo **`T`** como contenido en lugar de **`String`**. Esto nos permite imprimir cualquier tipo de documento de manera flexible y dinámica durante el proceso de codificación.

Veamos como queda el código de las clases especificas ahora:

Agregamos las clases `DocumentoPDF` y `DocumentoImprimible`

```java
public class DocumentoPDF {

    private String name;
    private String content;
    private int largo;
    private String path;
    public static final String EXTENSION = ".PDF";
 
	 // Constructores
	 // setters getters   
 }
```

```java
public class DocumentoImprimible {

    private String name;
    private String content;
	  
	 // Constructores
	 // setters getters 
}
```

Ahora vamos a cambiar las clases que implementan Impresora para que se especialicen en alguno de estos tipos de documentos:

```java
public class ImpresoraPDF implements Impresora <DocumentoPDF> { // 1 

    @Override
    public void imprimir(DocumentoPDF content) { // 2
        System.out.println("=".repeat(100));
        System.out.println(">> Iniciando Impresora PDF...");
        System.out.printf(">> Imprimiendo archivo PDF %s con el contenido: %s%n", content.getName(), content.getContent());
        System.out.printf(">> Archivo generado: %s%s%n", content.getName(), DocumentoPDF.EXTENSION);
        System.out.println("=".repeat(100));
    }
    
}
```

```java
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
```

```java
public class ImpresoraTinta implements Impresora<DocumentoImprimible> {

    @Override
    public void imprimir(DocumentoImprimible content) {
        System.out.println("=".repeat(100));
        System.out.printf(">> Iniciando Impresora de Tinta para imprimir %s%n.", content.getName());
        System.out.printf(">> Imprimiendo documento con contenido: %s%n", content.getContent());
        System.out.println(">> Archivo impreso correctamente con tinta.");
        System.out.println("=".repeat(100));
    }
    
}
```

1. Podemos ver que se agrega ahora en la declaración de la clase, el tipo al cual va a especializar nuestra clase, es decir ahora por ejemplo `ImpresoraPDF` implementa la interfaz Impresora haciendo que sus métodos sean específicos para la clase `DocumentoPDF`.
2. Vemos ahora, que todos los métodos imprimir  si bien reciben un tipo de parámetro diferente siguen siendo el mismo método imprimir de la interfaz permitiendo así la generalización al definir métodos.