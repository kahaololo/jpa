$(function() {

    //var login = getCookie("login");

    showUserChart("ololo");
});


function showUserChart (login) {
    $.getJSON(
        "/service/"+login+"/measurements",
        function( data ) {
            console.log(data);
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
                    type: 'spline',
                },
                title: {
                    text: '%UserName% chart',
                },
                xAxis: {
                    type: 'datetime',
                    dateTimeLabelFormats: {
                        day: '%b %e'
                    },
                },
                yAxis: {
                    title: {
                        text: 'Kg/Cm'
                    },
                },
                series: [{
                    name: 'Weight',
                    data: chartDataWeight
                }, {
                    name: 'Waist',
                    data: chartDataWaist
                }]
            });

        }
    );
}