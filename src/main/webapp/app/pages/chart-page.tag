<chart-page>
    <div if={measurements.length} id="chart">asd</div>

    <p if={!measurements.length}>No data records. Please create new one.</p>

    <script>
        this.measurements = this.opts.measurementService.getMeasurements();

        this.on("mount", function(){
            var chartDataWeight = [];
            var chartDataWaist = [];
            //
            this.measurements.forEach(function (measurement){
                chartDataWeight.push([
                    moment.utc(measurement.getDate()).valueOf(),
                    parseFloat(measurement.getWeight())
                ]);
                chartDataWaist.push([
                    moment.utc(measurement.getDate()).valueOf(),
                    parseFloat(measurement.getWaist())
                ]);
            });

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
    </script>
</chart-page>