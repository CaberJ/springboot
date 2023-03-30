package cn.caber.app.web.model.controller;

import cn.caber.app.server.model.command.PersonCmd;
import cn.caber.app.server.model.result.PersonVo;
import cn.caber.app.server.model.service.PersonService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/person")
public class PersonController {

    @DubboReference
    private PersonService personService;

    List<PersonVo> getList(PersonCmd cmd) {
        return personService.getList(cmd);
    }

}
