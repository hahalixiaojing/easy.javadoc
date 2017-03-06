package easy.javadoc.builder.http;

public class BasePackage {
    private String path;
    private String basePackage;

    public BasePackage(String path, String basePackage) {
        this.path = path;
        this.basePackage = basePackage;
    }

    public String getPath() {
        return path;
    }
    public String getBasePackage() {
        return basePackage;
    }
}
