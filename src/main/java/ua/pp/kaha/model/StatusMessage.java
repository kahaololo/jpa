package ua.pp.kaha.model;

import java.io.Serializable;

/**
 * Created by kaha on 16.02.2017.
 */
public class StatusMessage implements Serializable {
    private int status;
    private String message;



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
