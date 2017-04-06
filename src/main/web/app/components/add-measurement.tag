<add-measurement>

    <!-- Button trigger modal -->
    <button if={ this.isLoggedIn } class="btn btn-primary btn-lg" data-toggle="modal" id="addButton" data-target="#myModalNorm">
        Add
    </button>

    <!-- Modal -->
    <div if={ this.isLoggedIn } class="modal fade" id="myModalNorm" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">Add new record</h4>
                </div>


                <form onsubmit={addMeasurement}>
                    <!-- Modal Body -->
                    <div class="modal-body">

                        <div class="form-group">
                            <div class="input-group">
                                <span class="input-group-addon">date</span>
                                <input ref="date" type="date" class="form-control" id="inlineFormInputGroupDate">
                            </div>

                            <br>

                            <div class="input-group">
                                <span class="input-group-addon">kg</span>
                                <input ref="weight" type="number" step="0.1" class="form-control" placeholder="Weight">
                            </div>

                            <br>

                            <div class="input-group">
                                <span class="input-group-addon">cm</span>
                                <input ref="waist" type="number" step="0.1" class="form-control" placeholder="Waist">
                            </div>
                            <br>
                        </div>

                    </div>

                    <!-- Modal Footer -->
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">Add</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <style>
        #addButton {
            position: fixed;
            bottom: 5%;
            right: 5%;
        }
    </style>

    <script>
        let tag = this;

        tag.isLoggedIn = opts.isLoggedIn || false;

        tag.addMeasurement = function (e) {
            e.preventDefault();

            let date = this.refs.date;
            let weight = this.refs.weight;
            let waist = this.refs.waist;


            this.opts.measurementService.addMeasurement(date.value, weight.value, waist.value);

            setTimeout(function () {
                [date, weight, waist].forEach(function (el) {
                    el.value = '';
                });
                $('#myModalNorm').modal('hide');
            }, 300);

            Utils.notify("success", '<strong>Adding new entry</strong> Success!');
        }

        tag.opts.observable.on("logIn", function () {
            tag.isLoggedIn = true;
            tag.update();
        });

        tag.opts.observable.on("logOut", function () {
            tag.isLoggedIn = false;
            tag.update();
        });


    </script>


</add-measurement>