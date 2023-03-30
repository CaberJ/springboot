package cn.caber.caberspringbootstudy.dao;

import cn.caber.caberspringbootstudy.domain.Group;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@Mapper
public interface GroupDao{

    List<Group> findAll();
}
