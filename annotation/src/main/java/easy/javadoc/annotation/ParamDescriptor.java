package easy.javadoc.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(PARAMETER)
public @interface ParamDescriptor {
    String name();

    String description() default "";

    boolean isRequired() default false;

    String defaultValue() default "";
}
