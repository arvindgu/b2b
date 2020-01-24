package com.chocopay.registration.service.user;

import com.chocopay.registration.base.entity.User;
import com.chocopay.registration.dao.UserDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserManager {

    private final UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public User save(User user) {
        return userDao.save(user);
    }

    @Transactional(readOnly = true)
    public User getUser(Long userId) {
        return userDao.findById(userId).orElse(null);
    }

    @Transactional
    public void removeUser(Long userId) {
        userDao.deleteById(userId);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUser() {
        return userDao.findAll();
    }

    @Transactional
    public String login(String username, String password) {
        Optional<User> user = userDao.login(username, password);
        if(user.isPresent()){
            String token = UUID.randomUUID().toString();
            User custom = user.get();
            custom.setToken(token);
            userDao.save(custom);
            return token;
        }
        return StringUtils.EMPTY;
    }

    @Transactional(readOnly = true)
    public Optional<org.springframework.security.core.userdetails.User> findByToken(String token) {
        Optional<User> user =  userDao.findByToken(token);
        if(user.isPresent()){
            User user1 = user.get();
            org.springframework.security.core.userdetails.User chocoUser =
                    new org.springframework.security.core.userdetails.User(user1.getUserName(), user1.getPassword(),
                            true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(chocoUser);
        }
        return  Optional.empty();
    }
}
