package com.chocopay.registration.service.group;

import com.chocopay.registration.base.entity.Group;
import com.chocopay.registration.dao.GroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GroupManager {

    private final GroupDao groupDao;

    @Autowired
    public GroupManager(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Transactional
    public Group save(Group group) {
        return groupDao.save(group);
    }

    @Transactional(readOnly = true)
    public Group getGroup(Long groupId) {
        return groupDao.findById(groupId).orElse(null);
    }

    @Transactional
    public void removeGroup(Long groupId) {
        groupDao.deleteById(groupId);
    }

    @Transactional(readOnly = true)
    public List<Group> getAllGroup() {
        return groupDao.findAll();
    }
}
