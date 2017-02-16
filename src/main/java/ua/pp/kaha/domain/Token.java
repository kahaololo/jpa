package ua.pp.kaha.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kaha on 16.02.2017.
 */

public class Token implements Serializable {
    private static final long serialVersionUID = -186954891348069462L;
    private String authToken;
    private Date expires;

    public Token() { // for some reason the jackson engine needs a zero arg constructor.
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS zzz", timezone = "UTC")
    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

}