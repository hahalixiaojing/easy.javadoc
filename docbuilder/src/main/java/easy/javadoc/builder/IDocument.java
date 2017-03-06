package easy.javadoc.builder;


import easy.javadoc.builder.model.*;

/**
 * Created by lixiaojing3 on 2016/11/30.
 */
public interface IDocument {

    InterfaceTypeModel[] findByBasepackage(String basepackage) throws Exception;
    ClassTypeModel findClassByName(String clazz) throws Exception;

    MethodModel[] loadAllMethod(String clazz) throws Exception;

    ParameterModel[] findMethodParameters(String clazz, String method) throws Exception;


}
