package cn.caber.caberspringbootstudy.service.serviceImpl;

import cn.caber.caberspringbootstudy.dao.PeopleDao;
import cn.caber.caberspringbootstudy.domain.People;
import cn.caber.caberspringbootstudy.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleDao peopleDao;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    @Transactional
    public List<People> findAll() {

        List<People> peoples = new ArrayList<People>();

        //从redis中获取
        Long size = redisTemplate.opsForList().size("peoples");
        if (size == 0) {
            //从数据库中获取，存进redis
            peoples = peopleDao.findAll();
            for (People people : peoples) {
                redisTemplate.boundListOps("peoples").leftPush(people);
            }
        } else {
            for (Long i = 0L; i < size; i++) {
                peoples.add((People) redisTemplate.opsForList().rightPop("peoples"));
            }

        }

        return peoples;
    }

    @Override
    public People findPeopleById(String id) {
        return peopleDao.findPeopleById(id);
    }

    @Override
    public void insertOne(People people) {
        peopleDao.insertOne(people);
    }

    @Override
    public void updatePeople(People people) {
        peopleDao.updatePeople(people);
    }

    @Override
    public void deletePeople(String id) {
        peopleDao.deletePeople(id);
    }

    @Override
    public List<People> findByName(String name) {
        return peopleDao.findByName(name);
    }

    @Override
    public List<People> findByName1(String name) {
        return peopleDao.findByName1(name);
    }
}
