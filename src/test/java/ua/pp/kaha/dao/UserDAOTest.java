package ua.pp.kaha.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.pp.kaha.domain.User;

import static org.junit.Assert.assertNotNull;

/**
 * Created by skokhanenko on 13.04.2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-context.xml"})
public class UserDAOTest {

    @Autowired
    UserDAO userDao;

    @Test
    public void userCanBeRegistred() {

//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
//
//        UserDAO userDao = (UserDAO) context.getBean("userDao");

        User user = new User("Sergii Kokhanenko", "kokhanenko.s@gmail.com", "password");

        User newUser = userDao.register(user);

        assertNotNull(newUser);
        assertNotNull(newUser.getId());
    }

}