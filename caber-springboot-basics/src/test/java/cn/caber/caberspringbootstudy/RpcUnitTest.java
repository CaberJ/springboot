package cn.caber.caberspringbootstudy;


import cn.caber.caberspringbootstudy.component.Student;
import cn.caber.caberspringbootstudy.filter.MyFilter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = RpcUnitTest.class)
@Import({
        Student.class, // Spring DB 自动配置类
        MyFilter.class, // Spring 事务自动配置类
})
public class RpcUnitTest {

    @Autowired
    private Student student;

    @Test
    public void testSave() {
        int age = student.getAge();
        System.out.println(age);
    }
}
