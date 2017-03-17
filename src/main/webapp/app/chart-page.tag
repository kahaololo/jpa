<chart-page>
    <div if={measurements.length} class="divTable" style="border: 2px solid #000;">
        <div class="divTableBody">
            <div each={measurements} class="divTableRow" data-index="">
                <div class="divTableCell">{moment(date).format('DD-MM-YYYY')}</div>
                <div class="divTableCell">
                    <input type="number" name="weight" value={weight}>
                </div>
                <div class="divTableCell">
                    <input type="number" name="waist" value={waist}>
                </div>
                <div class="divTableCell">
                    <img class="icon edit" src="img/new-24.png">
                    <img class="icon remove" src="img/cross-24.png">
                </div>
            </div>
        </div>
    </div>

    <p if={!measurements.lengt}>No data records. Please create new one.</p>

    <script>
        this.measurements = [];

    </script>
</chart-page>