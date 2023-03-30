package cn.caber.springboot.test;

import org.springframework.util.CollectionUtils;

import java.util.*;


public class caberSon extends caber {

    private Map<String, String> sonOperator ;
    private String name;

    public caberSon() {
        super();
        this.sonOperator = new HashMap<>();
        this.name = "22";
        add();
    }

    @Override
    public String add(){
        sonOperator.put("aa","bb");
        return "bb";
    }

    public Map<String, String> getOperator() {
        return sonOperator;
    }

    public static void main(String[] args) {


        HashMap<String, Map<String, Integer>> stringMapHashMap = new HashMap<>();

        Map<String, Integer> aa = stringMapHashMap.getOrDefault("aa", new HashMap<>());
        aa.put("11",11);
        stringMapHashMap.put("aa",aa);
        Map<String, Integer> aa1 = stringMapHashMap.get("aa");
        System.out.println(aa1);

    }
}
