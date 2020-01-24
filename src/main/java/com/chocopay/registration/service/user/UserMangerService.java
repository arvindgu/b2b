package com.chocopay.registration.service.user;

import com.chocopay.registration.base.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserMangerService {

    private final UserManager userManager;

    @Autowired
    public UserMangerService(UserManager userManager) {
        this.userManager = userManager;
    }

    public User saveUser(User user) {
        return userManager.save(user);
    }

    public User getUser(Long userId) {
        return userManager.getUser(userId);
    }

    public boolean removeUser(Long userId) {
        userManager.removeUser(userId);
        return true;
    }

    public List<User> getAllUser() {
        return userManager.getAllUser();
    }

    public String login(String username, String password) {
        String token = userManager.login(username, password);
        if(StringUtils.isEmpty(token)){
            return "no token found";
        }
        return token;
    }

    public Optional<org.springframework.security.core.userdetails.User> findByToken(String token) {
        return userManager.findByToken(token);
    }
}
