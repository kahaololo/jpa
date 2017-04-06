<chart-page>
    <div if={measurements.length} id="chart"></div>

    <p if={!measurements.length}>No data records. Please create new one.</p>

    <script>
        var tag = this;
        tag.measurements = tag.opts.measurementService.getMeasurements("asc");

        tag.opts.observable.on("newMeasurement", function (measurement) {
            let chart = $("#chart").highcharts();
            chart.series[0].addPoint([moment.utc(measurement.getDate()).valueOf(), measurement.getWeight()]);
            chart.series[1].addPoint([moment.utc(measurement.getDate()).valueOf(), measurement.getWaist()]);
        });

        tag.on("mount", function () {

            let series = tag.createSeries(tag.measurements);

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
                    data: series.weight
                }, {
                    name: 'Waist',
                    data: series.waist
                }]
            });
        });

        tag.createSeries = function(measurements) {
            let chartDataWeight = [];
            let chartDataWaist = [];

            if (measurements && measurements.length)
                measurements.forEach(function (measurement) {
                    chartDataWeight.push([
                        moment.utc(measurement.getDate()).valueOf(),
                        measurement.getWeight()
                    ]);
                    chartDataWaist.push([
                        moment.utc(measurement.getDate()).valueOf(),
                        measurement.getWaist()
                    ]);
                });

            return {
                weight: chartDataWeight,
                waist: chartDataWaist
            };
        }
    </script>
</chart-page>