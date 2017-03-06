package easy.javadoc.builder.model;


import org.apache.commons.lang3.ObjectUtils;

public class MethodModel {
    /**
     * 方法名
     */
    private String name;
    /**
     * 方法描述
     */
    private String description;
    /**
     * 方法参数列表
     */
    private ParameterModel[] parameterModels;
    /**
     * 返回类型
     */
    private ReturnTypeModel returnModel;
    /**
     * 抛出异常名称列表
     */
    private String[] throwsException;

    public MethodModel(){
        this.setParameterModels(new ParameterModel[0]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ParameterModel[] getParameterModels() {
        return parameterModels;
    }

    public void setParameterModels(ParameterModel[] parameterModels) {
        this.parameterModels = ObjectUtils.defaultIfNull(parameterModels,new ParameterModel[0]);
    }


    public ReturnTypeModel getReturnModel() {
        return returnModel;
    }

    public void setReturnModel(ReturnTypeModel returnModel) {
        this.returnModel = returnModel;
    }

    public String[] getThrowsException() {
        return throwsException;
    }

    public void setThrowsException(String[] throwsException) {
        this.throwsException = throwsException;
    }
}
