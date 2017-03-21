/**
 * Created by skokhanenko on 17.03.2017.
 */
<results-page>
    <div if={measurements.length} class="divTable" style="border: 2px solid #000;">
        <div class="divTableBody">
            <div each={measurement in this.measurements} class="divTableRow" data-index="">
                <div class="divTableCell">{ moment(measurement.getDate()).format('DD-MM-YYYY') }</div>
                <div class="divTableCell">
                    <input type="number" name="weight" value={measurement.getWeight()}>
                </div>
                <div class="divTableCell">
                    <input type="number" name="waist" value={measurement.getWaist()}>
                </div>
                <div class="divTableCell">
                    <img class="icon edit" src="img/new-24.png">
                    <img class="icon remove" src="img/cross-24.png">
                </div>
            </div>
        </div>
    </div>

    <p if={!measurements.length}>No data records. Please create new one.</p>

    <script>
        var tag = this;
        tag.measurements = [];
        tag.opts.observable.on('measurementsUpdated', function (data) {
            tag.update({measurements: data});
        });

    </script>
</results-page>