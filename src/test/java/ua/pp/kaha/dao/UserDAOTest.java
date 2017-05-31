package ua.pp.kaha.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.kaha.model.Credentials;
import ua.pp.kaha.model.User;

import static org.junit.Assert.*;

/**
 * Created by skokhanenko on 13.04.2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-context.xml"})
public class UserDAOTest {

    @Autowired
    UserDAO userDao;

    @Test
    @Rollback(true)
    @Transactional
    public void userCanBeRegistred() {

        User user = new User("Sergii Kokhanenko", "newUser@gmail.com", "password");

        User newUser = userDao.register(user);

        assertNotNull(newUser);
        assertNotNull(newUser.getId());
    }

    @Test
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public void verifyUserCredentials() {
        Credentials invalidCredentials = new Credentials();
        Credentials validCredentials = new Credentials("kokhanenko.s@gmail.com", "verySecretPassword");

        assertFalse(userDao.areCredentialsValid(invalidCredentials));
        assertTrue(userDao.areCredentialsValid(validCredentials));
    }

}