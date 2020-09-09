package cn.caber.springboot.controller;

import cn.caber.springboot.model.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class RestTemplateDemo {

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String get(@RequestParam("name") String name, @RequestParam("age")Integer age){
        System.out.println("name = " + name +"&& age = " +age  );
        return name+":" + age;
    }

    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public String post(@RequestBody Person person){
        System.out.println(person.toString());
        return person.toString();
    }

    @RequestMapping(value = "/post/obj",method = RequestMethod.POST)
    public Person postObj(@RequestBody Person person){
        System.out.println(person.toString());
        return person;
    }

    @RequestMapping(value = "/post/str",method = RequestMethod.POST)
    public String postStr(@RequestBody String str){
        System.out.println(str);
        return str;
    }

    @RequestMapping(value = "/post/str1",method = RequestMethod.POST)
    public Person postStr1(@RequestBody String str){
        System.out.println(str);
        Person person = new Person();
        person.setName(str);
        person.setAge("12");
        return person;
    }

}
