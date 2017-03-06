package easy.javadoc.builder.doc;

import easy.javadoc.annotation.MethodDescriptor;
import easy.javadoc.builder.model.MethodModel;
import easy.javadoc.builder.model.ParameterModel;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TypeMethodReslover {
    private MethodParameterResolver methodParameterResolver;
    private MethodReturnTypeReslover methodReturnTypeReslover;

    public TypeMethodReslover(MethodParameterResolver methodParameterResolver, MethodReturnTypeReslover methodReturnTypeReslover) {

        this.methodParameterResolver = methodParameterResolver;
        this.methodReturnTypeReslover = methodReturnTypeReslover;
    }

    private String[] getThrowsEx(Method m) {

        List<String> strings = new ArrayList<String>();
        for (Class<?> cls : m.getExceptionTypes()) {
            strings.add(cls.getSimpleName());
        }
        return strings.toArray(new String[0]);
    }

    public MethodModel[] loadAllMethod(Class cls) {
        if (cls == null) {
            return new MethodModel[0];
        }

        List<MethodModel> methodModels = new ArrayList<MethodModel>();

        for (Method m : cls.getMethods()) {

            MethodDescriptor methodDescriptor = m.getAnnotation(MethodDescriptor.class);

            MethodModel methodModel = new MethodModel();
            methodModel.setName(m.getName());
            methodModel.setDescription(methodDescriptor.description());

            try {
                ParameterModel[] parameterModels = this.methodParameterResolver.loadAllParameter(m);
                methodModel.setParameterModels(parameterModels);
                methodModel.setReturnModel(this.methodReturnTypeReslover.getMethodReturnType(m));
                methodModel.setThrowsException(this.getThrowsEx(m));

                methodModels.add(methodModel);

            } catch (Exception e) {
            }
        }

        return methodModels.toArray(new MethodModel[0]);
    }
}
