package cn.caber.caberspringbootstudy.service;

import cn.caber.caberspringbootstudy.domain.People;

import java.util.List;

public interface PeopleService {
    List<People> findAll();
    People findPeopleById(String id);
    void insertOne (People people);
    void updatePeople(People people);
    void deletePeople(String id);
    List<People> findByName(String name);
    List<People> findByName1(String name);
}
