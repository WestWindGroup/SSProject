package net.artemenko.springsecurity.dao;

import net.artemenko.springsecurity.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

/**
 * Implementation of {@link UserDao} interface
 *
 * @author Eugen Artemenko
 * @version 1.0
 */

@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(User.class);

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        logger.debug("User saved in database. User " + user);
    }

    @Override
    public User findByUserName(String username) {
        Session session = sessionFactory.getCurrentSession();
        try {
            Query query = session.createQuery("from User as u where u.username=:name", User.class);
            query.setParameter("name",username);
            User user = (User)query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }
}
