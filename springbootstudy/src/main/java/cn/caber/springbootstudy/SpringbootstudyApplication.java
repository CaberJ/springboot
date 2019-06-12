package cn.caber.springbootstudy;

import cn.caber.springbootstudy.bean.User;
import cn.caber.springbootstudy.load.StreamResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

@SpringBootApplication
@ImportResource(value = "classpath:/flow/xml/beans.xml",reader = XmlBeanDefinitionReader.class)
public class SpringbootstudyApplication {

    private static InputStream inputStream;


    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        SpringApplication.run(SpringbootstudyApplication.class, args);

//        inputStream = getXml();
//        Resource resource = new InputStreamResource(inputStream);

//     doit();
    }

 /*   private static InputStream getXml() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/flow?useUnicode=true&amp;characterEncoding=utf-8";
        String user = "root";
        String psw = "root";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection(url, user, psw);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("select MS_TEPLET from t_flow_ms_choreography_info where MS_NO = 1 and MS_VERSION = 0.01;");

        InputStream binaryStream = resultSet.getBinaryStream("MS_TEPLET");
        return binaryStream;
    }*/


    /*public static void doit() throws IOException {
        //资源查找器
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:/flow/xml/beans.xml");
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(resource);
        Object user = xmlBeanFactory.getBean("InitHandle");
        System.out.println(user);
    }*/
}
