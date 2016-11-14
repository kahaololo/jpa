package ua.pp.kaha;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by skokhanenko on 14.11.2016.
 */
@Embeddable
public class MeasurmentId implements Serializable {
    @Column(name = "user_id")
    private int userId;
    private Date date;

    public MeasurmentId() {
    }

    public MeasurmentId(int userId, Date date) {
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
        if (o == null || getClass() != o.getClass()) return false;

        MeasurmentId that = (MeasurmentId) o;

        if (userId != that.userId) return false;
        if (!date.equals(that.date)) return false;

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
        return "MeasurmentId{" +
                "userId=" + userId +
                ", date=" + date +
                '}';
    }
}
