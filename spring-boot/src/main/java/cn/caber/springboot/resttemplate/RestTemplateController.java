package cn.caber.springboot.resttemplate;

import cn.caber.springboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequestMapping("/test")
public class RestTemplateController {


    private RestTemplate restTemplate;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get() {
        restTemplate = new RestTemplate();
        HashMap<String, Object> var = new HashMap<>();
        var.put("name", "zhangsan");
        var.put("age", 23);
        String forObject = restTemplate.getForObject("http://localhost:8080/rest/get?name={name}&age={age}", String.class, var);
        System.out.println("请求结果：" + forObject);
        return forObject;
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String post() {
        restTemplate = new RestTemplate();
        Person person = new Person();
        person.setAge("12");
        person.setName("libai");
        String s = restTemplate.postForObject("http://localhost:8080/rest/post", person, String.class);
        System.out.println(s);
        return s;
    }

    @RequestMapping(value = "/post/obj", method = RequestMethod.GET)
    public String postObj() {
        restTemplate = new RestTemplate();
        Person person = new Person();
        person.setAge("12");
        person.setName("libai");
        Person p = restTemplate.postForObject("http://localhost:8080/rest/post/obj", person, Person.class);
        System.out.println(p.toString());
        return p.toString();
    }

    @RequestMapping(value = "/post/map", method = RequestMethod.GET)
    public String postMap() {
        restTemplate = new RestTemplate();
        HashMap<String, Object> map = new HashMap<>();
        map.put("age",12);
        map.put("name","libai");
        Person p = restTemplate.postForObject("http://localhost:8080/rest/post/obj", map, Person.class);
        System.out.println(p.toString());
        return p.toString();
    }

    @RequestMapping(value = "/post/str1", method = RequestMethod.GET)
    public Person postStr() {
        restTemplate = new RestTemplate();
        String a = "libai";
        Person p = restTemplate.postForObject("http://localhost:8080/rest/post/str1", a, Person.class);
        System.out.println(p.toString());
        return p;
    }


}