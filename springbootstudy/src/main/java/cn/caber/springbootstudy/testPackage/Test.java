package cn.caber.springbootstudy.testPackage;

import cn.caber.springbootstudy.util.CompileUtils;
import cn.caber.springbootstudy.util.FreeMarkerUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/6/25 16:14
 */
@Component()
public class Test implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("name","User");

        String template = FreeMarkerUtils.getTemplate("class.ftl", stringObjectHashMap);
        System.out.println("template=="+template);
        try {
            CompileUtils.compile("cn.caber.springbootstudy.bean.User", template).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //注册bean

    }
}
