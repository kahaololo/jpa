package ua.pp.kaha.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ua.pp.kaha.domain.User;

/**
 * Created by skokhanenko on 13.04.2017.
 */

@Repository
public class HibernateUserDAO implements UserDAO {

    private SessionFactory sessionFactory;

    public HibernateUserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User register(User user) {
        Session     session = sessionFactory.getCurrentSession();
        Transaction tx      = session.beginTransaction();
        session.save(user);
        tx.commit();
        return user;
    }

}
