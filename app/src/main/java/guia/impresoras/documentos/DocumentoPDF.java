package guia.impresoras.documentos;

public class DocumentoPDF {

    private String name;
    private String content;
    private int largo;
    private String path;
    public static final String EXTENSION = ".PDF";

    public DocumentoPDF(String name, String content, int largo, String path) {
        this.name = name;
        this.content = content;
        this.largo = largo;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static String getExtension() {
        return EXTENSION;
    }

    

}
