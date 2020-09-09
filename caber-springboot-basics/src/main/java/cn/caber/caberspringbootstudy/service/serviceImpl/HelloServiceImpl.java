package cn.caber.caberspringbootstudy.service.serviceImpl;

import cn.caber.caberspringbootstudy.dao.PeopleDao;
import cn.caber.caberspringbootstudy.domain.People;
import cn.caber.caberspringbootstudy.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {




    @Override
    public String sayHello(){

        System.out.println("hello");
        return "hello";
    }



}
