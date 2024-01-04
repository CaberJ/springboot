package cn.caber.springbootstudy;

import cn.caber.springbootstudy.config.Bproperties;
import cn.caber.springbootstudy.config.ParentProperties;
import cn.caber.springbootstudy.util.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootstudyApplication {


    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(SpringbootstudyApplication.class, args);
        /*String aa = run.getEnvironment().getProperty("aa");
        PropertySource<?> map = run.getEnvironment().getPropertySources().get("map");
        System.out.println("map="+map);
        System.out.println("===="+aa);

        HashMap<String, Object> fMap = new HashMap<>();
        fMap.put("name","Abbc");
//        Object bean2 = run.getBean("abc");
//        System.out.println("bean2 = " + bean2);
        Class<?> user = CompileUtils.compile("cn.caber.springbootstudy.controller.AbbcController", FreeMarkerUtils.getTemplate("TestController.ftl", fMap));
        String name = user.getName();
        System.out.println("加载完毕，获取bean:"+name);


        BeanDefinitionBuilder userDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(user);
        ConfigurableApplicationContext applicationContext =(ConfigurableApplicationContext) SpringUtil.getApplicationContext();
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();
        beanFactory.registerBeanDefinition("abbcController",userDefinitionBuilder.getBeanDefinition());


        Object bean = run.getBean(user);
        System.out.println(bean);

        try {
            ControllerUtils.registerController("abbcController");
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        ParentProperties bean = (ParentProperties) SpringUtil.getBeanByName("parentProperties");
        System.out.println(bean);

        Bproperties beanByClass = (Bproperties) SpringUtil.getBeanByClass(Bproperties.class);
        System.out.println(beanByClass);


    }
}
