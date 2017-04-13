package ua.pp.kaha.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import ua.pp.kaha.domain.User;

/**
 * Created by skokhanenko on 13.04.2017.
 */

@Component
public class HibernateUserDAO implements UserDAO {

    private SessionFactory sessionFactory;

    public HibernateUserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User register(User user) {
        return null;
    }

}
