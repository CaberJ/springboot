package cn.caber.springbootstudy.load;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/6/24 16:13
 */
@Component
public class XmlReader implements BeanFactoryPostProcessor , EnvironmentAware, BeanFactoryAware {
    private Environment environment;
    private BeanFactory beanFactory;

    //    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        ResultSet resultSet;
        String xmlstr = "";

        String usr = environment.getProperty("jdbc.usr");
        String psw = environment.getProperty("jdbc.psw");
        String url =environment.getProperty("jdbc.url");

        //获取xml
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, usr, psw);
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("select AS_TEPLET from t_flow_as_choreography_info where AS_NO = 1 and AS_VERSION =1.0");
            if (resultSet.next()) {
                xmlstr = resultSet.getString(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //调试代码
        System.out.println(xmlstr);
        Resource streamResource = new ByteArrayResource(xmlstr.getBytes());

        DefaultListableBeanFactory bf = (DefaultListableBeanFactory) beanFactory;
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);
        //关闭xml校验
//        reader.setValidating(false);
        //设置校验方式为xsd
        reader.setValidationMode(3);
        reader.loadBeanDefinitions(streamResource);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment=environment;
    }
}
