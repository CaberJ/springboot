package cn.caber.springbootstudy.condition;

import cn.caber.springbootstudy.bean.ConditionBean;
import cn.caber.springbootstudy.bean.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/11/14 15:31
 */

@Configuration
public class ConditionTest {


    @Bean("conditionBean")
    @ConditionalOnProperty(prefix="conditionTest",name = "condition", havingValue = "on")
    @ConditionalOnMissingBean(ConditionBean.class)
    public ConditionBean getOn(){
        ConditionBean on = new ConditionBean();
        on.setStatus("on");

        return on;
    }

    @Bean("conditionBean")
    @ConditionalOnProperty(prefix="conditionTest",name = "condition", havingValue = "on")
    @ConditionalOnMissingBean(ConditionBean.class)
    public ConditionBean getOff(){
        ConditionBean off = new ConditionBean();
        off.setStatus("off");
        return off;
    }
}
