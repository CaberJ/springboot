package cn.caber.app.server.model.service;

import cn.caber.app.server.model.command.PersonCmd;
import cn.caber.app.server.model.result.PersonVo;

import java.util.List;

public interface PersonService {

    List<PersonVo> getList(PersonCmd personCmd);
}
