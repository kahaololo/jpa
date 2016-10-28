package ua.pp.kaha;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skokhanenko on 28.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setId(123);
        user.setName("oloolo");
        List measurments = new ArrayList();
        user.addMeasurment(new Measurment(123,123));
        user.addMeasurment(new Measurment(123,123));
        System.out.print(user);
    }
}
