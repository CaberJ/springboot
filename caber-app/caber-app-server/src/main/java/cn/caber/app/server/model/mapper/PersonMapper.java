package cn.caber.app.server.model.mapper;

import cn.caber.app.common.dao.CaberMapper;
import cn.caber.app.server.model.command.PersonCmd;
import cn.caber.app.server.model.entity.Person;
import cn.caber.app.server.model.result.PersonVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonMapper extends CaberMapper<Person> {
    List<PersonVo> getList(@Param("cmd") PersonCmd cmd);
}
