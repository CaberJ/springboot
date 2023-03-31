package cn.caber.app.web.model.controller;

import cn.caber.app.server.model.command.PersonCmd;
import cn.caber.app.server.model.result.PersonVo;
import cn.caber.app.server.model.service.PersonService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @DubboReference
    private PersonService personService;

    @PostMapping("/getList")
    List<PersonVo> getList(@RequestBody PersonCmd cmd) {
        return personService.getList(cmd);
    }

}
