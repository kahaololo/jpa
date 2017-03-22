/**
 * Created by kahas on 3/21/2017.
 */
class MeasurementService {
    constructor(obs) {
        this.obs = obs;
        this.url = "#api/";
        this.measurements = null;
    }

    getMeasurements() {
        if (this.measurements === null)
            this.measurements = this.fetchJson();
        return this.measurements;
    }

    fetchJson() {
        let measurements = [
            new Measurement(new Date("2016-11-24"),96,81),
            new Measurement(new Date("2016-11-25"),83,83),
            new Measurement(new Date("2016-11-26"),81,82),
            new Measurement(new Date("2016-11-27"),88,86),
            new Measurement(new Date("2016-11-28"),83,87),
            new Measurement(new Date("2016-11-29"),99,80),
            new Measurement(new Date("2016-11-30"),89,83),
            new Measurement(new Date("2016-12-01"),84,84),
            new Measurement(new Date("2016-12-02"),89,88),
            new Measurement(new Date("2016-12-03"),82,82),
            new Measurement(new Date("2016-12-04"),88,81),
            new Measurement(new Date("2016-12-05"),81,85),
            new Measurement(new Date("2016-12-06"),81,85),
            new Measurement(new Date("2016-12-07"),89,80),
            new Measurement(new Date("2016-12-08"),90,81),
            new Measurement(new Date("2016-12-09"),85,81),
            new Measurement(new Date("2016-12-10"),95,88),
            new Measurement(new Date("2016-12-11"),84,89),
            new Measurement(new Date("2016-12-12"),99,89),
            new Measurement(new Date("2016-12-13"),91,85),
            new Measurement(new Date("2016-12-14"),97,83),
            new Measurement(new Date("2016-12-15"),99,82),
            new Measurement(new Date("2016-12-16"),88,86),
            new Measurement(new Date("2016-12-17"),87,82),
            new Measurement(new Date("2016-12-18"),82,84),
            new Measurement(new Date("2016-12-19"),83,89),
            new Measurement(new Date("2016-12-20"),98,83),
            new Measurement(new Date("2016-12-21"),82,85),
            new Measurement(new Date("2016-12-22"),85,86),
            new Measurement(new Date("2016-12-23"),91,84),
            new Measurement(new Date("2016-12-24"),96,83)
        ];
        this.obs.trigger("measurementsUpdated", measurements);
        return measurements;
    }

    removeMeasurement(index) {
        this.measurements.splice(index,1);
    }

    updateMeasurement(index, weigth, waist) {
        let measurement = this.measurements[index];
        measurement.setWeight(weigth);
        measurement.setWaist(waist);
    }
}