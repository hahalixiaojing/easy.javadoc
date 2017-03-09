package easy.javadoc.builder.doc;


import easy.javadoc.annotation.ReturnDescriptor;
import easy.javadoc.builder.model.ReturnTypeModel;

import java.lang.reflect.Method;

public class MethodReturnTypeReslover {

    public ReturnTypeModel getMethodReturnType(Method m) throws Exception{
        ReturnDescriptor descriptor = m.getAnnotation(ReturnDescriptor.class);

        Class<?> returnType = null;
        if (descriptor.returnType().equals(Void.class)) {
            returnType = m.getReturnType();
        } else {
            returnType = descriptor.returnType();
        }

        if (returnType.getName().toLowerCase().equals("void")) {
            ReturnTypeModel returnTypeModel = new ReturnTypeModel();
            returnTypeModel.setDescription("无返回值");
            returnTypeModel.setType("void");
            returnTypeModel.setTypeName("void");
            return returnTypeModel;
        } else {
            ReturnTypeModel returnTypeModel = new ReturnTypeModel();
            returnTypeModel.setDescription(descriptor.description());
            if (returnType.isArray()) {
                returnTypeModel.setType(returnType.getComponentType().getName());
                returnTypeModel.setTypeName(returnType.getSimpleName());
            } else {
                returnTypeModel.setType(returnType.getName());
                returnTypeModel.setTypeName(returnType.getSimpleName());
            }
            return returnTypeModel;
        }
    }
}
