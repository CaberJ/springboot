package cn.caber.caberspringbootstudy.service.serviceImpl;

import cn.caber.caberspringbootstudy.dao.GroupDao;
import cn.caber.caberspringbootstudy.domain.Group;
import cn.caber.caberspringbootstudy.domain.People;
import cn.caber.caberspringbootstudy.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Override
    public List<Group> fingAll() {
        List<Group> all = groupDao.findAll();
        return all;
    }
}
