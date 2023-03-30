package cn.caber.app.server.model.service;

import cn.caber.app.server.model.command.PersonCmd;
import cn.caber.app.server.model.fetcher.PersonFetcher;
import cn.caber.app.server.model.result.PersonVo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DubboService(interfaceClass = PersonService.class)
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonFetcher personFetcher;

    @Override
    public List<PersonVo> getList(PersonCmd personCmd) {
        List<PersonVo> list = personFetcher.getList(personCmd);
        return list;
    }
}
