package easy.javadoc.builder.doc;

import easy.javadoc.annotation.ParamDescriptor;
import easy.javadoc.builder.model.GenericTypeModel;

public class GenericTypeReslover {

    public static GenericTypeModel[] genericTypeModels(Class<?>[] classes) {
        GenericTypeModel[] genericTypeModels = new GenericTypeModel[classes.length];

        int i = 0;
        for (Class<?> type : classes) {
            GenericTypeModel genericTypeModel = new GenericTypeModel();

            if (type.isArray()) {
                String arrayTypeName = type.getComponentType().getName();
                String typeName = type.getSimpleName();
                genericTypeModel.setType(arrayTypeName);
                genericTypeModel.setTypeName(typeName);

            } else {
                genericTypeModel.setTypeName(type.getSimpleName());
                genericTypeModel.setType(type.getName());
            }


            genericTypeModels[i] = genericTypeModel;

            i++;
        }
        return genericTypeModels;
    }
}
