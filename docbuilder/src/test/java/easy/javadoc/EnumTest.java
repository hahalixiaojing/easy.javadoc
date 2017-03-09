package easy.javadoc;

import org.junit.Test;

import java.lang.reflect.Field;

public class EnumTest {
    @Test
    public void parseTest() throws NoSuchFieldException {

        Field myEnum = MyObj.class.getField("myEnum");

    }
}
