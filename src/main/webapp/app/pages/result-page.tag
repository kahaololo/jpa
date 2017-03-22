/**
* Created by skokhanenko on 17.03.2017.
*/
<results-page>
    <div if={measurements.length} class="divTable" style="border: 2px solid #000;">
        <div class="divTableBody">
            <div each={measurement, index in this.measurements} class="divTableRow" data-index="{index}">
                <div class="divTableCell">{ moment(measurement.getDate()).format('DD-MM-YYYY') }</div>
                <div class="divTableCell">
                    <input type="number" name="weight" value={measurement.getWeight()}>
                </div>
                <div class="divTableCell">
                    <input type="number" name="waist" value={measurement.getWaist()}>
                </div>
                <div class="divTableCell">
                    <img class="icon edit" src="img/new-24.png" onclick={change}>
                    <img class="icon remove" src="img/cross-24.png" onclick={remove}>
                </div>
            </div>
        </div>
    </div>

    <p if={!measurements.length}>No data records. Please create new one.</p>

    <script>
        var tag = this;
        tag.measurements = tag.opts.measurementService.getMeasurements();

        this.remove = function(e) {
            tag.opts.measurementService.removeMeasurement(e.item.index);
        };

        this.change = function(e) {
            let row = $(e.target).closest('div.divTableRow');
            let waist = row.find('input[name="waist"]').val();
            let weight = row.find('input[name="weight"]').val();
            tag.opts.measurementService.updateMeasurement(e.item.index, weight, waist);
        };
    </script>
</results-page>