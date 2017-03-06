package easy.javadoc.builder.model;

/**
 * Created by lixiaojing3 on 2016/12/6.
 */
public class InterfaceTypeModel extends TypeModel {
    private MethodModel[] methodModels;

    public MethodModel[] getMethodModels() {
        return methodModels;
    }

    public void setMethodModels(MethodModel[] methodModels) {
        this.methodModels = methodModels;
    }
}
