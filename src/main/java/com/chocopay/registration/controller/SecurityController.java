package com.chocopay.registration.controller;

import com.chocopay.registration.base.entity.Business;
import com.chocopay.registration.service.business.BusinessMangerService;
import com.chocopay.registration.service.user.UserMangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
public class SecurityController {

    @Autowired
    private UserMangerService userMangerService;
    @Autowired
    private BusinessMangerService businessMangerService;

    @PostMapping("/login")
    public Callable<String> getToken(@RequestParam("username") final String username, @RequestParam("password") final String password){
        return  () -> userMangerService.login(username,password);
    }

    @PostMapping("/signup")
    public Callable<Business> signUp(@RequestBody Business business){
        return () -> businessMangerService.saveBusiness(business);
    }
}
