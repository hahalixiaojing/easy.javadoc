package easy.javadoc.web.test;


import easy.javadoc.annotation.*;

@TypeDescriptor(description = "获得测数据接口")
public interface ITestInterface2 {

    @MethodDescriptor(description = "获得测试方法数据")
    @ReturnDescriptor(description = "无返回值")
    void testMethod(
            @ParamDescriptor(name = "a", defaultValue = "aTest", isRequired = true, description = "a参数")             String a,
            @ParamDescriptor(name = "b", defaultValue = "bTest", isRequired = true, description = "b参数")
                    Integer b,
            @ParamDescriptor(name = "testModel", defaultValue = "null", description = "testModel")
                    TestModel testModel,
            @ParamDescriptor(name = "testModels", defaultValue = "[]", description = "数组描述")
                    TestModel[] testModels);

    @MethodDescriptor(description = "测试有返回值")
    @ReturnDescriptor(description = "返回testModel")
    TestModel testModel2();

    @MethodDescriptor(description = "测试返回列表")
    @ReturnDescriptor(description = "返回testModelArray")
    TestModel[] testModel3();
    @MethodDescriptor(description = "测试泛型返回结果")
    @ReturnDescriptor(description = "测试泛型返回结果",genericTypes = {TestModel.class})
    Result<TestModel> test4();
}
