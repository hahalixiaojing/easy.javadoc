package easy.javadoc;

import org.junit.Test;

import java.lang.reflect.Field;

public class GenericTypeTest {
    @Test
    public void getGenericTest() throws NoSuchFieldException {

        Field list = MyObj.class.getField("list");

        list.getType().getTypeParameters();

    }
}
