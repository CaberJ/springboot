package cn.caber.springbootstudy.parseXMLDemo;


import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/6/13 9:58
 */
public class ParseXml {
    public static void main(String[] args) {

        String xmlstr="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<beans xmlns=\"http://www.springframework.org/schema/beans\"\n" +
                "       xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "       xsi:schemaLocation=\"http://www.springframework.org/schema/beans\n" +
                "    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd\">\n" +
                "\n" +
                "    <bean id=\"user\" class=\"cn.caber.springbootstudy.bean.User\">\n" +
                "        <property name=\"name\" value=\"aaa\"/>\n" +
                "    </bean>\n" +
                "\n" +
                "    <bean id=\"InitHandle\" class=\"cn.caber.springbootstudy.bean.InitHandle\" scope=\"singleton\" init-method=\"init\" destroy-method=\"destroy\">\n" +
                "    </bean>\n" +
                "\n" +
                "  <bean class=\"cn.caber.springbootstudy.bean.PostProcessor\">\n" +
                "  </bean>\n" +
                "</beans>";
        SAXBuilder saxbBuilder = new SAXBuilder();
        InputStream bais = new ByteArrayInputStream(xmlstr.getBytes());
        /*StringReader stringReader = new StringReader(xmlstr);
        InputSource inputSource = new InputSource(stringReader);*/
        try {
//            Document doc = saxbBuilder.build(inputSource);
            Document doc = saxbBuilder.build(bais);
            Element rootElement = doc.getRootElement();
            System.out.println(rootElement.getName());

            List children = rootElement.getChildren();
            for (int i = 0; i < children.size(); i++) {
                Element element = (Element) children.get(i);
                System.out.println(element.getName());
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
