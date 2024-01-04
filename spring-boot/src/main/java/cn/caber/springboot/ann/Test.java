package cn.caber.springboot.ann;

import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) throws NoSuchMethodException {
        Method get = TestAnn.class.getMethod("get");
        AnnotatedElementUtils.getMergedAnnotationAttributes(get, Son.class);
        Son son = get.getAnnotation(Son.class);
        AnnotatedElementUtils.getMergedAnnotationAttributes(get, Farther.class);
        Farther farther = get.getAnnotation(Farther.class);
        System.out.println(son.toString());
        System.out.println(farther.toString());
    }
}
