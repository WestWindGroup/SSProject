package net.artemenko.springsecurity.dao;

import net.artemenko.springsecurity.model.User;

public interface UserDao {

    void save(User user);

    User findByUserName(String username);
}
