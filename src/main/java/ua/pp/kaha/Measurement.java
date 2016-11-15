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
@Table(name = "Measurements")
public class Measurement {
    @EmbeddedId
    private MeasurementId measurementId;

    @Column(nullable = false)
    private int waist;

    @Column(nullable = false)
    private int weight;

    public Measurement() {
    }

    public Measurement(int userId, Date date, int waist, int weight) {
        this.measurementId = new MeasurementId(userId, date);
        this.waist = waist;
        this.weight = weight;
    }

    public MeasurementId getMeasurementId() {
        return measurementId;
    }

    public void setMeasurementId(MeasurementId measurementId) {
        this.measurementId = measurementId;
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
        return "Measurement{" +
                "measurementId=" + measurementId +
                ", waist=" + waist +
                ", weight=" + weight +
                '}';
    }
}
