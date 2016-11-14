package ua.pp.kaha;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by skokhanenko on 28.10.2016.
 */
@Entity
@Table(name = "Users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "UsersGen")
    @TableGenerator(name = "UsersGen", table = "sqlite_sequence", allocationSize = 1, valueColumnName = "seq", pkColumnName = "name")
    private int id;
    private String name;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Measurment> measurments= new ArrayList<Measurment>();

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

    public void addMeasurment(Date date, int waist, int weight) {
        measurments.add(new Measurment(id, date, waist, weight));
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
