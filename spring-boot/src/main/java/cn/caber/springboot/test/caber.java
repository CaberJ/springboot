package cn.caber.springboot.test;

import java.util.HashMap;
import java.util.Map;

public class caber {

    private Map<String, String> operator;
    private String name;

    public caber() {
        this.operator = new HashMap<>();
        this.name = "11";
        add();
    }

    public String add() {
        operator.put("aa", "aa");
        return "aa";
    }


}
