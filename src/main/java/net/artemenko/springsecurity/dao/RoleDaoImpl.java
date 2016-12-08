package net.artemenko.springsecurity.dao;

import net.artemenko.springsecurity.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * Implementation of {@link RoleDao} interface
 *
 * @author Eugen Artemenko
 * @version 1.0
 */

@Repository
public class RoleDaoImpl implements RoleDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role getRole(long id) {
        Session session = sessionFactory.getCurrentSession();
        Role role = session.load(Role.class, id);
        return role;
    }
}
