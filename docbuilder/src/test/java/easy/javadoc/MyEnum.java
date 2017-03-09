package easy.javadoc;

import easy.javadoc.annotation.EnumDescriptor;
import easy.javadoc.annotation.FieldDescriptor;
import easy.javadoc.annotation.TypeDescriptor;

@TypeDescriptor(description = "dsfd")
public enum MyEnum {
    @FieldDescriptor(descripion = "dsdds")
    Test1,
    @FieldDescriptor(descripion = "dsdds")
    Test2
}
