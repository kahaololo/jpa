package ua.pp.kaha.domain;

import java.io.Serializable;

/**
 * Created by kaha on 15.02.2017.
 */
public class Credentials implements Serializable {
    private String email;
    private String password;

    public Credentials() {
    }

    public Credentials(String name, String password) {
        this.email = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
