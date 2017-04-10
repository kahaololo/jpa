package ua.pp.kaha.dao;

import ua.pp.kaha.domain.Measurement;

import java.util.List;

/**
 * Created by skokhanenko on 14.03.2017.
 */
public interface IMeasurementDAO {
    List<Measurement> getUserMeasurements(String username);
}
