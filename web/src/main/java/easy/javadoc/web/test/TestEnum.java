package easy.javadoc.web.test;

import easy.javadoc.annotation.EnumDescriptor;
import easy.javadoc.annotation.FieldDescriptor;
import easy.javadoc.annotation.TypeDescriptor;

@TypeDescriptor(description = "测试枚举")
public enum TestEnum {
    @EnumDescriptor(descripion = "dsfsdf")
    Test1,
    @EnumDescriptor(descripion = "dsfsdf")
    Test2
}
