package cn.caber.springboot;

import java.util.ArrayList;
import java.util.List;

public class LocalTest {

    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();
        Object obj = strings;
        if( obj instanceof List){
            System.out.println("list");
        }

    }
}
