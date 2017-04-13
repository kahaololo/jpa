package ua.pp.kaha.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by skokhanenko on 14.11.2016.
 */
@Embeddable
public class MeasurementId implements Serializable {
    @Column(name = "user_id")
    private int userId;

    @Column(name = "dt")
    private Date date;

    public MeasurementId() {
    }

    public MeasurementId(int userId, Date date) {
        this.userId = userId;
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeasurementId)) return false;

        MeasurementId that = (MeasurementId) o;

        if (date != that.date) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MeasurementId{" +
                "userId=" + userId +
                ", date=" + date +
                '}';
    }
}
