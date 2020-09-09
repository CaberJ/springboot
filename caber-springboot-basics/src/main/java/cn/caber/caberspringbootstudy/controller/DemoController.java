package cn.caber.caberspringbootstudy.controller;

import cn.caber.caberspringbootstudy.domain.People;
import cn.caber.caberspringbootstudy.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@ConfigurationProperties(prefix = "people")//这样使用必须提供set方法
public class DemoController {

    private String id;
    private String name;
    private int age;

    @Autowired
    private People a;

    @Autowired
    private PeopleService peopleService;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @RequestMapping("/getOne")
    public String getPeople() {
        return "springboot 访问成功! id = " + id + "name=" + name + ",age=" + age;
    }

    @RequestMapping("/a")
    public String a() {
        return a.toString();
    }

    @RequestMapping("/b")
    public List<People> b() {
        List<People> peoples =peopleService.findAll();
        return peoples;
    }


}
