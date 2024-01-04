package cn.caber.springboot.test;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("11", "22", "33");
        ArrayList<String> strs = new ArrayList<>(list);

        Bean1 bean1 = new Bean1();
        bean1.setName("张三");
        bean1.setNickName("zhangsan");
        bean1.setGender(Boolean.FALSE);
        bean1.setStrs(strs);
        //bean1.setAge(12);

        Bean2 bean2 = new Bean2();
        bean2.setAge(1);
        BeanUtils.copyProperties(bean1,bean2);
        System.out.println(bean2);
        List<String> strs1 = bean2.getStrs();
        strs1.add("aa");
        System.out.println(strs);
        System.out.println(strs1);
    }
}
