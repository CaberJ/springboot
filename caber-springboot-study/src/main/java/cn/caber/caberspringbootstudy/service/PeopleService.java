package cn.caber.caberspringbootstudy.service;

import cn.caber.caberspringbootstudy.domain.People;

import java.util.List;

public interface PeopleService {
    List<People> findAll();
}
