package cn.caber.app.server.model.handler;

import cn.caber.app.server.model.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = false, transactionManager = "transactionManager", rollbackFor = Throwable.class)
public class PersonHandler {

    @Autowired
    private PersonMapper personMapper;

}
