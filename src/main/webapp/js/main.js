$(function() {

    //var login = getCookie("login");

    showUserChart("kaha");
});


function showUserChart (login) {
    $.getJSON(
        "/service/"+login+"/measurements",
        function( data ) {
            console.log(data);
            //var chartDataWeight = [];
            //var chartDataWaist = [];
            //
            //for (var i in data) {
            //    var routine = data[i];
            //    chartDataWeight.push( [new Date(routine.date).getTime(), routine.weight ] );
            //    chartDataWaist.push( [new Date(routine.date).getTime(), routine.waist ] );
            //}
            //
            //$('#chart').highcharts({
            //    chart: {
            //        type: 'spline',
            //    },
            //    title: {
            //        text: '%UserName% chart',
            //    },
            //    xAxis: {
            //        type: 'datetime',
            //        dateTimeLabelFormats: {
            //            day: '%b %e'
            //        },
            //    },
            //    yAxis: {
            //        title: {
            //            text: 'Kg/Cm'
            //        },
            //    },
            //    series: [{
            //        name: 'Weight',
            //        data: chartDataWeight
            //    }, {
            //        name: 'Waist',
            //        data: chartDataWaist
            //    }]
            //});

        }
    );
}