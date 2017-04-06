package ua.pp.kaha.domain;

import java.io.Serializable;

/**
 * Created by kaha on 15.02.2017.
 */
public class Credentials implements Serializable {
    private String email;
    private String password;

    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
