package easy.javadoc;


import easy.javadoc.annotation.FieldDescriptor;

public class MyObj {
    @FieldDescriptor(descripion = "dsss", defaultValue = "Test1", isRequired = true)
    public MyEnum myEnum;
}
