package cn.caber.springboot.test;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Indexed
@Documented
@Inherited
public @interface Farther {

    String name() default "";

    int age() default 0;

}
