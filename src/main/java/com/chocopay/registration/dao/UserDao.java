package com.chocopay.registration.dao;

import com.chocopay.registration.base.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u where u.userName = ?1 and u.password = ?2 ")
    Optional<User> login(String username, String password);

    Optional<User> findByToken(String token);
}
