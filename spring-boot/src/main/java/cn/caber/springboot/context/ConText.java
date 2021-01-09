package cn.caber.springboot.context;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class ConText {
    private static final Map<String,String> map = new ConcurrentHashMap<>();
    private static volatile ConText conText;
    private ConText(){}

    public static Map<String,String> getMap(){
        if(Objects.isNull(conText)){
            synchronized (ConText.class){
                if(Objects.isNull(conText)){
                    conText = new ConText();
                }
            }
        }
        return conText.map;
    }


}
