package cn.caber.springbootstudy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootstudyApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void contextLoads() throws ClassNotFoundException {
        System.out.println(applicationContext.containsBean("user"));
    }

}
