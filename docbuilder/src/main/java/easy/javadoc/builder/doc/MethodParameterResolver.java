package easy.javadoc.builder.doc;

import easy.javadoc.annotation.ParamDescriptor;
import easy.javadoc.builder.model.ParameterModel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class MethodParameterResolver {

    public ParameterModel[] loadAllParameter(Method method) throws Exception {

        List<ParameterModel> parameterModels = new ArrayList<ParameterModel>();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();

        int paramIndex = 0;
        for (Annotation[] annotations : parameterAnnotations) {
            for (int i = 0; i < annotations.length; i++) {
                if (annotations[i] instanceof ParamDescriptor) {
                    ParamDescriptor paramDescriptor = (ParamDescriptor) annotations[i];
                    ParameterModel parameterModel = new ParameterModel();
                    parameterModel.setDescription(paramDescriptor.description());
                    parameterModel.setName(paramDescriptor.name());
                    parameterModel.setRequired(paramDescriptor.isRequired());
                    parameterModel.setDefaultValue(paramDescriptor.defaultValue());

                    boolean isArray = method.getParameterTypes()[paramIndex].isArray();
                    if (isArray) {
                        String arrayTypeName = method.getParameterTypes()[paramIndex].getComponentType().getName();
                        String typeName = method.getParameterTypes()[paramIndex].getSimpleName();
                        parameterModel.setType(arrayTypeName);
                        parameterModel.setTypeName(typeName);
                        parameterModel.setArray(true);
                    } else {
                        parameterModel.setType(method.getParameterTypes()[paramIndex].getName());
                        parameterModel.setTypeName(method.getParameterTypes()[paramIndex].getSimpleName());
                    }
                    parameterModel.setArray(isArray);
                    parameterModels.add(parameterModel);
                    break;
                }
            }
            paramIndex++;
        }
        return parameterModels.toArray(new ParameterModel[0]);
    }
}
