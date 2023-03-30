package cn.caber.app.server.model.fetcher;

import cn.caber.app.server.model.command.PersonCmd;
import cn.caber.app.server.model.mapper.PersonMapper;
import cn.caber.app.server.model.result.PersonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(readOnly = true, transactionManager = "transactionManager", rollbackFor = Throwable.class)
public class PersonFetcher {

    @Autowired
    private PersonMapper personMapper;

    public List<PersonVo> getList(PersonCmd cmd) {
        return personMapper.getList(cmd);
    }
}
