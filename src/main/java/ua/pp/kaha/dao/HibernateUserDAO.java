package ua.pp.kaha.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.kaha.domain.Credentials;
import ua.pp.kaha.domain.User;
import ua.pp.kaha.utils.CommonUtils;

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

    @Override
    public boolean areCredentialsValid(Credentials credentials) {
        Session     session = sessionFactory.getCurrentSession();
        Transaction tx      = session.beginTransaction();
        Criteria userCreteria = session.createCriteria(User.class);
        userCreteria.add(Restrictions.eq("email", credentials.getEmail()));
        User user = (User) userCreteria.uniqueResult();

        return user != null && user.getPassword().equals(CommonUtils.getSHA256String(credentials.getPassword()));

    }
}
