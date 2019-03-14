package cn.caber.caberspringbootstudy.dao;

import cn.caber.caberspringbootstudy.domain.People;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper
public interface PeopleDao {

    //注解方式
/*
    @Select("select * from people")
    List<People> findAll();
*/

    //mapper.xml方式
    List<People> findAll();


}
