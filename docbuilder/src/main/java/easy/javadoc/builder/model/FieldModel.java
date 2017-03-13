package easy.javadoc.builder.model;

public class FieldModel {
    private String name;
    private String type;
    private String typeName;
    private String description;
    private String defaultValue;
    private boolean isRequired;
    private GenericTypeModel[] genericTypeModels = new GenericTypeModel[0];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setescription(String description) {
        this.description = description;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
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
