package ua.pp.kaha.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.pp.kaha.model.User;

/**
 * Created by skokhanenko on 13.04.2017.
 */

@Repository
public class HibernateUserDAO implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateUserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User register(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        Criteria userCreteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        userCreteria.add(Restrictions.eq("email", email));

        return (User) userCreteria.uniqueResult();
    }


}
