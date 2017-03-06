package easy.javadoc.builder.model;


import org.apache.commons.lang3.ObjectUtils;

public class ClassTypeModel extends  TypeModel {
    private  FieldModel[] fieldModels;

    public ClassTypeModel(){
        this.setFieldModels(new FieldModel[0]);
    }

    public FieldModel[] getFieldModels() {
        return fieldModels;
    }

    public void setFieldModels(FieldModel[] fieldModels) {
        this.fieldModels = ObjectUtils.defaultIfNull(fieldModels,new FieldModel[0]);
    }
}
