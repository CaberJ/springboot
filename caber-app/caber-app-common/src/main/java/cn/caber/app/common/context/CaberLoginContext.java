package cn.caber.app.common.context;


import cn.caber.app.common.constant.LogInConstant;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CaberLoginContext {

    private static final ThreadLocal<Map<String, Object>> caberLoginContext = ThreadLocal.withInitial(HashMap::new);

    public static void put(String key, Object value) {
        Map<String, Object> map = caberLoginContext.get();
        if (Objects.isNull(map)) {
            map = new HashMap<>();
        }
        map.put(key, value);
        caberLoginContext.set(map);
    }

    public static Object get(String key) {
        Map<String, Object> map = caberLoginContext.get();
        if (Objects.isNull(map)) {
            return null;
        }
        return map.get(key);
    }

    public static String getOperator() {
        return (String) get(LogInConstant.OPERATOR);
    }

}
