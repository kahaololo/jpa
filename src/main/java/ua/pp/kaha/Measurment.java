package ua.pp.kaha;

/**
 * Created by skokhanenko on 28.10.2016.
 */
public class Measurment {
    private int userId;
    private int waist;
    private int weight;

    public Measurment() {
    }

    public Measurment(int waist, int weight) {
        this.waist = waist;
        this.weight = weight;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
                "waist=" + waist +
                ", weight=" + weight +
                '}';
    }
}
