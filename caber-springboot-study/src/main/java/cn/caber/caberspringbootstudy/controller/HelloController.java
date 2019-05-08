package cn.caber.caberspringbootstudy.controller;

import cn.caber.caberspringbootstudy.component.Student;
import cn.caber.caberspringbootstudy.domain.People;
import cn.caber.caberspringbootstudy.service.HelloService;
import cn.caber.caberspringbootstudy.timedTask.springTask.ScheduledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class HelloController {

    @Value("${people.id}")
    private String id;

    @Value("${people.name}")
    private String name;

    @Value("${people.age}")
    private int age;

    @Value("${people.age}")
    private String gid;

    @Autowired
    private Student s;

    @Autowired
    private HelloService helloService;


    @RequestMapping("/getPeople")
    public String getPeople(){

        return new People(id,name,age,gid).toString();
    }

    @RequestMapping("/aa")
    public String getStudent(){

        return s.toString();
    }

    @RequestMapping(value = "/requestBody",method = RequestMethod.POST)
    public String requestBody(@RequestBody List<People> peoples){
        for (People people : peoples) {
            System.out.println(people.toString());
        }
        return peoples.toString();
    }

    @RequestMapping("/do")
    public String sayHello(){
        String s = helloService.sayHello();
        return s;
    }



}
