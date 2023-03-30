package cn.caber.caberspringbootstudy.controller;

import cn.caber.caberspringbootstudy.domain.Group;
import cn.caber.caberspringbootstudy.domain.People;
import cn.caber.caberspringbootstudy.service.GroupService;
import cn.caber.caberspringbootstudy.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private GroupService groupService;

    @RequestMapping("/a")
    public List<People> findAll() {
        List<People> peoples =peopleService.findAll();
        return peoples;
    }
    @RequestMapping("/b")
    public People findPeopleById(String id){
        People peo = peopleService.findPeopleById(id);
        return peo;
    }

    @RequestMapping("/c")
    public void findPeopleById(){
        peopleService.insertOne(new People("3","lisi",23,"a"));
    }

    @RequestMapping("/d")
    public void updatePeople(){
        peopleService.updatePeople(new People("3","lisi",23,"a"));
    }

    @RequestMapping("/e")
    public void deletePeople(String id){
        peopleService.deletePeople(id);
    }

    @RequestMapping("/f")
    public List<People> findByName(String name) {
        List<People> peoples =peopleService.findByName(name);
        return peoples;
    }

    @RequestMapping("/g")
    public List<People> findByName1(String name) {
        List<People> peoples =peopleService.findByName1(name);
        return peoples;
    }

    @RequestMapping("/h")
    public List<Group> findAllGroup() {
        List<Group> groups = groupService.fingAll();
        return groups;
    }


}
