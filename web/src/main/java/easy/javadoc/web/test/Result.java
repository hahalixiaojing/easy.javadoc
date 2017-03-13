package easy.javadoc.web.test;


import easy.javadoc.annotation.FieldDescriptor;
import easy.javadoc.annotation.TypeDescriptor;

@TypeDescriptor(description = "测试泛型")
public class Result<T> {
    @FieldDescriptor(descripion = "泛型字段", defaultValue = "null")
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
