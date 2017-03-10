package easy.javadoc.web.test;


import easy.javadoc.annotation.*;

import java.util.List;
import java.util.Map;

@TypeDescriptor(description = "获得测数据接口")
public interface ITestInterface {

    @MethodDescriptor(description = "获得测试方法数据")
    @ReturnDescriptor(description = "无返回值")
    void testMethod(
            @ParamDescriptor(name = "a", defaultValue = "aTest", isRequired = true, description = "a参数")
                    String a,
            @ParamDescriptor(name = "b", defaultValue = "bTest", isRequired = true, description = "b参数")
                    Integer b,
            @ParamDescriptor(name = "testModel", defaultValue = "null", description = "testModel")
                    TestModel testModel,
            @ParamDescriptor(name = "testModels", defaultValue = "[]", description = "数组描述")
                    TestModel[] testModels,
            @ParamDescriptor(name = "m", defaultValue = "[]", isRequired = true, description = "m参数")
                    int[] m,
            @ParamDescriptor(name = "m1", defaultValue = "0", isRequired = true, description = "m1参数")
                    int m1,
            @ParamDescriptor(name = "m2", defaultValue = "null", isRequired = true, description = "m1参数")
                    Integer[] m2

    );

    @MethodDescriptor(description = "测试有返回值")
    @ReturnDescriptor(description = "返回testModel")
    TestModel testModel2(@ParamDescriptor(name = "stringList", description = "sd", defaultValue = "[]", isRequired = true, genericTypes = {String.class}) List<String> stringList) throws Exception;

    @MethodDescriptor(description = "测试返回列表")
    @ReturnDescriptor(description = "返回testModelArray")
    TestModel[] testModel3(@ParamDescriptor(name = "modelMap", defaultValue = "null", description = "泛型测试", genericTypes = {String.class, TestModel.class   }) Map<String, TestModel> modelMap) throws Exception;
}
