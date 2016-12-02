
$(function() {

    var login = "Kaha";
    loadUserChart(login);

    $("#table").on('click', '.remove', removeMeasurement);
    $("#table").on('click', '.edit', editMeasurement);
    $("#table").on('click', '.edit', addMeasurement);


});

function addMeasurement() {
    var tr = $(this).parent().parent();

    var measurement = {
        date: $(tr).children().eq(0).children("input").val(),
        weight: $(tr).children().eq(1).children("input").val(),
        waist: $(tr).children().eq(2).children("input").val()
    };

    var request = $.ajax({
        method: "POST",
        url: "/service/measurements/",
        data: {
            user: login,
            measurement: measurement
        }
    });

    request.done(function (message) {
        console.log(data);
        console.log(message);
    });

}

function removeMeasurement() {
    $(this).parent().parent().fadeOut(350, function(){
        $(this).remove();
    });
}

function editMeasurement() {
    var tr = $(this).parent().parent();
}

function loadUserChart (login) {

    var request = $.ajax({
        method: "GET",
        url: "/service/measurements/",
        data: {
            user: login
        }
    });

    request.done(function (data) {
        //render table template
        var source   = $("#table-template").html();
        var template = Handlebars.compile(source);
        $("#table").html(template(data));

        var chartDataWeight = [];
        var chartDataWaist = [];
        //
        for (var i in data) {
            var routine = data[i];
            chartDataWeight.push( [new Date(routine.measurementId.date).getTime(), routine.weight ] );
            chartDataWaist.push( [new Date(routine.measurementId.date).getTime(), routine.waist ] );
        }
        //
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