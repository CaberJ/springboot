package cn.caber.springboot.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.Objects;

public class JsonDemo {

    public static void main(String[] args) {
        String a = "[]";
        JSONArray obj = JSON.parseArray(a);
        System.out.println(Objects.isNull(obj));
        System.out.println(obj.size());
        System.out.println(obj.isEmpty());

    }
}
