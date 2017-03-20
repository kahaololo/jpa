/**
 * Created by skokhanenko on 20.03.2017.
 */

function Measurement(date, weight, waist) {
    this.date = date;
    this.weight = weight;
    this.waist = waist;
}

Measurement.prototype.setDate = function(date) {
    this.date = date;
};

Measurement.prototype.getDate = function() {
    return this.date;
};

Measurement.prototype.setWeight = function(w) {
    this.weight = w;
};

Measurement.prototype.getWeight = function() {
    return this.weight;
};

Measurement.prototype.setWaist = function(w) {
    this.waist = w;
};

Measurement.prototype.getWaist = function() {
    return this.waist;
};
