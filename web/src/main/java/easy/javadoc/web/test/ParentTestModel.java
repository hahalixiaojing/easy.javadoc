package easy.javadoc.web.test;


import easy.javadoc.annotation.FieldDescriptor;
import easy.javadoc.annotation.TypeDescriptor;

@TypeDescriptor(description = "ParentTestModel")
public class ParentTestModel {
    @FieldDescriptor(descripion = "test描述",defaultValue = "null")
    private String test;
}
