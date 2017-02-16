package ua.pp.kaha.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

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

    public Measurement(int userId, long date, int waist, int weight) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Measurement that = (Measurement) o;

        if (!measurementId.equals(that.measurementId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return measurementId.hashCode();
    }
}
