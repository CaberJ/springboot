package cn.caber.caberspringbootstudy.service;

import cn.caber.caberspringbootstudy.domain.People;
import org.springframework.stereotype.Service;

@Service
public class HelloService {


    public String sayHello(){
        return "hello";
    }


}
