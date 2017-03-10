package easy.javadoc.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Retention(RUNTIME)
@Target(FIELD)
public @interface FieldDescriptor {
    String descripion() default "";

    String defaultValue() default "";

    boolean isRequired() default false;

    Class<?>[] genericTypes() default {};
}
