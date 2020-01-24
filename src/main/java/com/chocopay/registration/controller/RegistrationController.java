package com.chocopay.registration.controller;

import com.chocopay.registration.base.entity.*;
import com.chocopay.registration.service.account.AccountMangerService;
import com.chocopay.registration.service.business.BusinessMangerService;
import com.chocopay.registration.service.group.GroupMangerService;
import com.chocopay.registration.service.role.RoleMangerService;
import com.chocopay.registration.service.user.UserMangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Callable;

@RestController
@RequestMapping(value = {"/chocopay/v1"})
public class RegistrationController {

    private final BusinessMangerService businessMangerService;
    private final RoleMangerService roleMangerService;
    private final UserMangerService userMangerService;
    private final GroupMangerService groupMangerService;
    private final AccountMangerService accountMangerService;

    @Autowired
    public RegistrationController(BusinessMangerService businessMangerService,
                                  RoleMangerService roleMangerService,
                                  UserMangerService userMangerService,
                                  GroupMangerService groupMangerService,
                                  AccountMangerService accountMangerService) {
        this.businessMangerService = businessMangerService;
        this.roleMangerService = roleMangerService;
        this.userMangerService = userMangerService;
        this.groupMangerService = groupMangerService;
        this.accountMangerService = accountMangerService;
    }

    @PostMapping("/business/")
    public Callable<Business> saveBusiness(@RequestBody Business business) {
        return () -> businessMangerService.saveBusiness(business);
    }

    @GetMapping("/business/{businessId}")
    public Callable<Business> getBusiness(@PathVariable Long businessId) {
        return () -> businessMangerService.getBusiness(businessId);
    }

    @DeleteMapping("/business/{businessId}")
    public Callable<Boolean> removeBusiness(@PathVariable Long businessId) {
        return () ->  businessMangerService.removeBusiness(businessId);
    }

    @GetMapping("/business/")
    public Callable<List<Business>> getAllBusiness() {
        return businessMangerService::getAllBusiness;
    }

    @PostMapping("/user/")
    public Callable<User> saveUser(@RequestBody User user) {
        return () -> userMangerService.saveUser(user);
    }

    @GetMapping("/user/{userId}")
    public Callable<User> getUser(@PathVariable Long userId) {
        return () -> userMangerService.getUser(userId);
    }

    @DeleteMapping("/user/{userId}")
    public Callable<Boolean> removeUser(@PathVariable Long userId) {
        return () ->  userMangerService.removeUser(userId);
    }

    @GetMapping("/user/")
    public Callable<List<User>> getAllUser() {
        return userMangerService::getAllUser;
    }

    @PostMapping("/group/")
    public Callable<Group> saveGroup(@RequestBody Group group) {
        return () -> groupMangerService.saveGroup(group);
    }

    @GetMapping("/group/{groupId}")
    public Callable<Group> getGroup(@PathVariable Long groupId) {
        return () -> groupMangerService.getGroup(groupId);
    }

    @DeleteMapping("/group/{groupId}")
    public Callable<Boolean> removeGroup(@PathVariable Long groupId) {
        return () ->  groupMangerService.removeGroup(groupId);
    }

    @GetMapping("/group/")
    public Callable<List<Group>> getAllGroup() {
        return groupMangerService::getAllGroup;
    }

    @PostMapping("/role/")
    public Callable<Role> saveRole(@RequestBody Role role) {
        return () -> roleMangerService.saveRole(role);
    }

    @GetMapping("/role/{roleId}")
    public Callable<Role> getRole(@PathVariable Long roleId) {
        return () -> roleMangerService.getRole(roleId);
    }

    @DeleteMapping("/role/{roleId}")
    public Callable<Boolean> removeRole(@PathVariable Long roleId) {
        return () ->  roleMangerService.removeRole(roleId);
    }

    @GetMapping("/role/")
    public Callable<List<Role>> getAllRole() {
        return roleMangerService::getAllRole;
    }

    @PostMapping("/account/")
    public Callable<Account> saveAccount(@RequestBody Account account) {
        return () -> accountMangerService.saveAccount(account);
    }

    @GetMapping("/account/{accountId}")
    public Callable<Account> getAccount(@PathVariable Long accountId) {
        return () -> accountMangerService.getAccount(accountId);
    }

    @DeleteMapping("/account/{accountId}")
    public Callable<Boolean> removeAccount(@PathVariable Long accountId) {
        return () ->  accountMangerService.removeAccount(accountId);
    }

    @GetMapping("/account/")
    public Callable<List<Account>> getAllAccount() {
        return accountMangerService::getAllAccount;
    }

}
