package ua.pp.kaha;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skokhanenko on 28.10.2016.
 */
public class User {
    private int id;
    private String name;
    private List<Measurment> measurments = new ArrayList<Measurment>();

    public User() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Measurment> getMeasurments() {
        return measurments;
    }

    public void setMeasurments(List<Measurment> measurments) {
        this.measurments = measurments;
    }

    public void addMeasurment(Measurment measurment) {
        measurments.add(measurment);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", measurments=" + measurments +
                '}';
    }
}
