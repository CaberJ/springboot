package cn.caber.springbootstudy.load;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/6/6 10:30
 */
public class MyXmlBeanDefinitionReader extends XmlBeanDefinitionReader {

    public MyXmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }
}
