package ua.pp.kaha;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by skokhanenko on 28.10.2016.
 */
@Entity
@Table(name = "Measurments")
public class Measurment {
    @EmbeddedId
    private MeasurmentId measurmentId;

    @Column(nullable = false)
    private int waist;

    @Column(nullable = false)
    private int weight;

    public Measurment() {
    }

    public Measurment(int userId, Date date, int waist, int weight) {
        this.measurmentId = new MeasurmentId(userId, date);
        this.waist = waist;
        this.weight = weight;
    }

    public MeasurmentId getMeasurmentId() {
        return measurmentId;
    }

    public void setMeasurmentId(MeasurmentId measurmentId) {
        this.measurmentId = measurmentId;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Measurment{" +
                "measurmentId=" + measurmentId +
                ", waist=" + waist +
                ", weight=" + weight +
                '}';
    }
}
