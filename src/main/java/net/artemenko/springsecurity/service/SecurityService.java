package net.artemenko.springsecurity.service;

/**
 * service for security
 *
 * @author Eugen Artemenko
 * @version 1.0
 */

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
