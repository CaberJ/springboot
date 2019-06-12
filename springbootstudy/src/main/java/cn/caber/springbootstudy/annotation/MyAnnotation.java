package cn.caber.springbootstudy.annotation;

import cn.caber.springbootstudy.load.MyBeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/5/29 11:08
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface MyAnnotation {
    @AliasFor("locations")
    String[] value() default {};

    @AliasFor("value")
    String[] locations() default {};

    Class<? extends MyBeanDefinitionReader> reader() default MyBeanDefinitionReader.class;
}
