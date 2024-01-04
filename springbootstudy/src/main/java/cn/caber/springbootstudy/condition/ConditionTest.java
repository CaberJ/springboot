package cn.caber.springbootstudy.condition;

import cn.caber.springbootstudy.bean.ConditionBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/11/14 15:31
 */

@Configuration
public class ConditionTest {
    
    
    @Bean("conditionBean")
    //prefix 数组，获取property名称的前缀，可有可无
    //name 数组，property完整名称或部分名称，与prefix组合使用组成完整属性名称，与value不可同时存在
    //value 数组，获取property完整名称或部分名称，与prefix组合使用成完整属性名称，与name不可同时存在
    //havingValue 比较获取的属性值与havingValue给定的值是否相同，相同才加载配置类
    //matchIfMissing 缺少property时是否加载，如果为true，没有该property属性也会正常加载，反之报错。
    @ConditionalOnProperty(prefix = "conditionTest", name = "condition", havingValue = "on")
    @ConditionalOnMissingBean(ConditionBean.class)
    public ConditionBean getOn() {
        ConditionBean on = new ConditionBean();
        on.setStatus("on");
        
        return on;
    }
    
    @Bean("conditionBean")
    @ConditionalOnProperty(prefix = "conditionTest", name = "condition", havingValue = "on")
    @ConditionalOnMissingBean(ConditionBean.class)
    public ConditionBean getOff() {
        ConditionBean off = new ConditionBean();
        off.setStatus("off");
        return off;
    }

}
