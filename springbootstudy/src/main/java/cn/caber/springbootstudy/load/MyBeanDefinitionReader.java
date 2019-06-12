package cn.caber.springbootstudy.load;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.io.Resource;

import java.io.StringReader;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/5/29 11:07
 */
public class MyBeanDefinitionReader extends AbstractBeanDefinitionReader {


    protected MyBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    public int loadBeanDefinitions(Resource resource) throws BeanDefinitionStoreException {
        return 0;
    }
}
