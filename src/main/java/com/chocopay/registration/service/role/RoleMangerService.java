package com.chocopay.registration.service.role;

import com.chocopay.registration.base.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RoleMangerService {

    private final RoleManager roleManager;

    @Autowired
    public RoleMangerService(RoleManager roleManager) {
        this.roleManager = roleManager;
    }

    public Role saveRole(Role role) {
        return roleManager.save(role);
    }

    public Role getRole(Long roleId) {
        return roleManager.getRole(roleId);
    }

    public boolean removeRole(Long roleId) {
        roleManager.removeRole(roleId);
        return true;
    }

    public List<Role> getAllRole() {
        return roleManager.getAllRole();
    }
}
