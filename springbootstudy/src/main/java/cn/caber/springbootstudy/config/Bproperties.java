package cn.caber.springbootstudy.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Bproperties {

    //@Value("${aa.name}")
   //private static String name;  // 静态属性获取不到

    @Value("${aa.name}")
    private static String name;
}
