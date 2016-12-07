package net.artemenko.springsecurity.service;

import net.artemenko.springsecurity.model.User;

/**
 * service class for {@link User}
 *
 * @author Eugen Artemenko
 * @version 1.0
 */

public interface UserService {

    void save(User user);

    User findByUserName(String username);
}
