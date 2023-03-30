package cn.caber;


import java.util.HashMap;
import java.util.Map;

class caberTest {

    static Map<String, String> staMap;

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        staMap = map;
        map.put("aa","bb");
        System.out.println(staMap);


    }
}