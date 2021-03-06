package easy.javadoc.builder.model;


public class ReturnTypeModel {
    private String description;
    private String type;
    private String typeName;
    private GenericTypeModel[] genericTypeModels;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public GenericTypeModel[] getGenericTypeModels() {
        return genericTypeModels;
    }

    public void setGenericTypeModels(GenericTypeModel[] genericTypeModels) {
        this.genericTypeModels = genericTypeModels;
    }
}
