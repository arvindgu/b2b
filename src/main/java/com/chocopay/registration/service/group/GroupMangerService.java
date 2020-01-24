package com.chocopay.registration.service.group;

import com.chocopay.registration.base.entity.Group;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GroupMangerService {

    private final GroupManager groupManager;

    @Autowired
    public GroupMangerService(GroupManager groupManager) {
        this.groupManager = groupManager;
    }

    public Group saveGroup(Group business) {
        return groupManager.save(business);
    }

    public Group getGroup(Long businessId) {
        return groupManager.getGroup(businessId);
    }

    public boolean removeGroup(Long businessId) {
        groupManager.removeGroup(businessId);
        return true;
    }

    public List<Group> getAllGroup() {
        return groupManager.getAllGroup();
    }
}
