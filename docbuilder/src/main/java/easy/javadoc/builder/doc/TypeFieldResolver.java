package easy.javadoc.builder.doc;

import easy.javadoc.annotation.EnumDescriptor;
import easy.javadoc.annotation.FieldDescriptor;
import easy.javadoc.builder.model.FieldModel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TypeFieldResolver {
    public FieldModel[] loadAllFields(Class<?> clazz) {

        if (clazz == null) {
            return new FieldModel[0];
        }
        List<FieldModel> fieldModels = new ArrayList<FieldModel>();
        Field[] declaredFields = clazz.getDeclaredFields();

        for (int i = 0; i < declaredFields.length; i++) {
            FieldDescriptor fieldDescriptor = declaredFields[i].getAnnotation(FieldDescriptor.class);
            if (fieldDescriptor != null) {
                FieldModel fieldModel = this.getFieldDescriptor(fieldDescriptor, declaredFields[i]);
                fieldModels.add(fieldModel);
            } else {
                EnumDescriptor enumDescriptor = declaredFields[i].getAnnotation(EnumDescriptor.class);
                if (enumDescriptor != null) {
                    FieldModel fieldModel = this.getEnumDescriptor(enumDescriptor, declaredFields[i]);
                    fieldModels.add(fieldModel);
                }
            }
        }

        FieldModel[] fieldModels1 = this.loadAllFields(clazz.getSuperclass());
        fieldModels.addAll(Arrays.asList(fieldModels1));

        return fieldModels.toArray(new FieldModel[0]);
    }

    private FieldModel getEnumDescriptor(EnumDescriptor enumDescriptor, Field field) {
        FieldModel fieldModel = new FieldModel();
        fieldModel.setName(field.getName());
        fieldModel.setDefaultValue("-");
        fieldModel.setescription(enumDescriptor.descripion());
        fieldModel.setType(field.getType().getName());

        this.setArray(fieldModel, field);
        return fieldModel;
    }

    private FieldModel getFieldDescriptor(FieldDescriptor fieldDescriptor, Field field) {
        FieldModel fieldModel = new FieldModel();
        fieldModel.setName(field.getName());
        fieldModel.setDefaultValue(fieldDescriptor.defaultValue());
        fieldModel.setescription(fieldDescriptor.descripion());
        fieldModel.setRequired(fieldDescriptor.isRequired());
        fieldModel.setType(field.getType().getName());

        this.setArray(fieldModel, field);
        return fieldModel;
    }

    private void setArray(FieldModel fieldModel, Field field) {
        if (field.getType().isArray()) {
            String arrayTypeName = field.getType().getComponentType().getName();
            String typeName = field.getType().getSimpleName();
            fieldModel.setType(arrayTypeName);
            fieldModel.setTypeName(typeName);
        } else {
            fieldModel.setTypeName(field.getType().getSimpleName());
        }
    }
}
