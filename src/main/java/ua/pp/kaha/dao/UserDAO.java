package ua.pp.kaha.dao;

import ua.pp.kaha.model.User;

/**
 * Created by skokhanenko on 13.04.2017.
 */
public interface UserDAO {
    User register(User user);

    User getUserByEmail(String email);
}
