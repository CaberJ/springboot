package cn.caber.caberspringbootstudy.controller;

import cn.caber.caberspringbootstudy.component.Student;
import cn.caber.caberspringbootstudy.domain.People;
import cn.caber.caberspringbootstudy.timedTask.springTask.ScheduledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @Value("${people.id}")
    private String id;

    @Value("${people.name}")
    private String name;

    @Value("${people.age}")
    private int age;

    @Autowired
    private Student s;




    @RequestMapping("/getPeople")
    public String getPeople(){

        return new People(id,name,age).toString();
    }

    @RequestMapping("/aa")
    public String getStudent(){

        return s.toString();
    }



}
