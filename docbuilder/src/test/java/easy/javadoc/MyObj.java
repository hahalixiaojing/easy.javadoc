package easy.javadoc;


import easy.javadoc.annotation.FieldDescriptor;

import java.util.List;

public class MyObj {
    @FieldDescriptor(descripion = "dsss", defaultValue = "Test1", isRequired = true)
    public MyEnum myEnum;
    @FieldDescriptor(descripion = "", defaultValue = "[]", isRequired = true, genericTypes = {String.class})
    public List<String> list;
}
