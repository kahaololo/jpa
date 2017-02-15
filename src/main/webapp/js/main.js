var tableTemplate, loginTemplate, measurementsData;


$(function () {
    var user = {
        name: "Kaha",
        id: 1,
        measurements: []
    };

    //render table template
    tableTemplate = Handlebars.compile($("#table-template").html());
    loginTemplate = Handlebars.compile($("#login-template").html());

    Handlebars.registerHelper('dateformat', function (ms) {
        return moment(ms).format('DD.MM.YYYY');
    });


    loadUserChart(user);

    $("#table").on('click', '.remove', function () {
        removeMeasurement(this, user);
    });
    $("#table").on('click', '.edit', function () {
        editMeasurement(this, user);
    });
    $("#table").on('click', '.add', function () {
        addMeasurement(this, user);
    });


});


function addMeasurement(that, user) {
    var tr = $(that).parent().parent();
    var dateVal = $(tr).children().eq(0).children("input").val();
    var weightVal = $(tr).children().eq(1).children("input").val();
    var waistVal = $(tr).children().eq(2).children("input").val();

    var measurement = {
        measurementId: {
            date: (new Date(dateVal)).getTime(),
            userId: user.id
        },
        weight: parseFloat(weightVal),
        waist: parseFloat(waistVal)
    };

    var request = $.ajax({
        method: "PUT",
        url: "/service/measurements/",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(measurement),
        statusCode: {
            401: function() {
                $("#form").html(loginTemplate);
            }
        }
    });

    request.done(function (rs) {
        if (!rs.status) {
            console.log(rs.errMsg);
            return false;
        }
        var chart = $("#chart").highcharts();
        var weightSeries = chart.series[0];
        var waistSeries = chart.series[1];
        weightSeries.addPoint([measurement.measurementId.date, parseFloat(measurement.weight)]);
        waistSeries.addPoint([measurement.measurementId.date, parseFloat(measurement.waist)]);

        measurementsData.push(measurement);
        //update template
        $("#table").empty();
        $("#table").html(tableTemplate(measurementsData));

        // clear inputs
        tr.find("input").val('');
    });

}

function removeMeasurement(that, user) {
    var tr = $(that).parent().parent();
    var i = tr.data("index");

    var request = $.ajax({
        method: "DELETE",
        url: "/service/measurements/",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(measurementsData[i]),
        statusCode: {
            401: function() {
                $("#form").html(loginTemplate);
            }
        }
    });

    request.done(function (rs) {
        if (!rs.status) {
            console.log(rs.errMsg);
            return false;
        }
        var chart = $("#chart").highcharts();
        chart.series[0].data[i].remove(true, true);
        chart.series[1].data[i].remove(true, true);

        measurementsData.splice(i, 1);

        $("#table").empty();
        $("#table").html(tableTemplate(measurementsData));
    });
}

function editMeasurement(that, user) {
    var tr = $(that).parent().parent();
    var i = tr.data("index");

    var weightVal = $(tr).children().eq(1).children("input").val();
    var waistVal = $(tr).children().eq(2).children("input").val();

    if (weightVal == measurementsData[i].weight && waistVal == measurementsData[i].waist) {
        return false;
    }

    measurementsData[i].weight = parseFloat(weightVal);
    measurementsData[i].waist = parseFloat(waistVal);

    // update y only

    var request = $.ajax({
        method: "POST",
        url: "/service/measurements/",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(measurementsData[i]),
        statusCode: {
            401: function() {
                $("#form").html(loginTemplate);
            }
        }
    });
    //
    request.done(function (rs) {
        if (!rs.status) {
            console.log(rs.errMsg);
            return false;
        }

        var chart = $("#chart").highcharts();
        chart.series[0].data[i].update({x: measurementsData[i].measurementId.date, y: measurementsData[i].weight});
        chart.series[1].data[i].update({x: measurementsData[i].measurementId.date, y: measurementsData[i].waist});
    });
}

function loadUserChart(user) {


    var request = $.ajax({
        method: "GET",
        url: "/service/users/" + user.id,
        statusCode: {
            401: function() {
                $("#form").html(loginTemplate);
            }
        }
    });

    request.done(function (data) {
        if (!data) {
            console.log("user is null - need to be redirected");
        }
        measurementsData = data.measurements;
        $("#table").html(tableTemplate(measurementsData));

        var chartDataWeight = [];
        var chartDataWaist = [];
        //
        for (var i in data.measurements) {
            var routine = data.measurements[i];
            chartDataWeight.push([routine.measurementId.date, parseFloat(routine.weight)]);
            chartDataWaist.push([routine.measurementId.date, parseFloat(routine.waist)]);
        }

        $('#chart').highcharts({
            chart: {
                type: 'spline'
            },
            title: {
                text: '%UserName% chart'
            },
            xAxis: {
                type: 'datetime',
                dateTimeLabelFormats: {
                    day: '%b %e'
                }
            },
            yAxis: {
                title: {
                    text: 'Kg/Cm'
                }
            },
            series: [{
                name: 'Weight',
                data: chartDataWeight
            }, {
                name: 'Waist',
                data: chartDataWaist
            }]
        });

    });
}