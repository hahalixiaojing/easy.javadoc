package easy.javadoc.builder.doc;

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

            if (fieldDescriptor == null) {
                continue;
            }
            FieldModel fieldModel = new FieldModel();
            fieldModel.setName(declaredFields[i].getName());
            fieldModel.setDefaultValue(fieldDescriptor.defaultValue());
            fieldModel.setescription(fieldDescriptor.descripion());
            fieldModel.setRequired(fieldDescriptor.isRequired());
            fieldModel.setType(declaredFields[i].getType().getName());

            if (declaredFields[i].getType().isArray()) {
                String arrayTypeName = declaredFields[i].getType().getComponentType().getName();
                String typeName = declaredFields[i].getType().getSimpleName();
                fieldModel.setType(arrayTypeName);
                fieldModel.setTypeName(typeName);
                fieldModel.setArray(true);
            } else {
                fieldModel.setArray(declaredFields[i].getType().isArray());
                fieldModel.setTypeName(declaredFields[i].getType().getSimpleName());
            }
            fieldModels.add(fieldModel);
        }

        FieldModel[] fieldModels1 = this.loadAllFields(clazz.getSuperclass());
        fieldModels.addAll(Arrays.asList(fieldModels1));

        return fieldModels.toArray(new FieldModel[0]);
    }
}
