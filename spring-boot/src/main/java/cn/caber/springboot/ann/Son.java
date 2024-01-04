package cn.caber.springboot.ann;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Indexed;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Indexed
@Inherited
@Documented
@Farther
public @interface Son {

    @AliasFor(annotation = Farther.class)
    String name();

    @AliasFor(annotation = Farther.class)
    int age();

    String wife();

    String brother();
}
