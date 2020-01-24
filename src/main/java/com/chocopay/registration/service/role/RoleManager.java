package com.chocopay.registration.service.role;

import com.chocopay.registration.base.entity.Role;
import com.chocopay.registration.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RoleManager {

    private final RoleDao roleDao;

    @Autowired
    public RoleManager(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Transactional
    public Role save(Role role) {
        return roleDao.save(role);
    }

    @Transactional(readOnly = true)
    public Role getRole(Long roleId) {
        return roleDao.findById(roleId).orElse(null);
    }

    @Transactional
    public void removeRole(Long roleId) {
        roleDao.deleteById(roleId);
    }

    @Transactional(readOnly = true)
    public List<Role> getAllRole() {
        return roleDao.findAll();
    }
}
