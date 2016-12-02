<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <script src="http://code.jquery.com/jquery-2.2.0.min.js"></script>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="js/main.js"></script>
    <script src="js/handlebars.js"></script>
    <link rel="stylesheet" type="text/css" href="css/table.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>


<script id="table-template" type="text/x-handlebars-template">
    <div class="divTable" style="border: 2px solid #000;">
        <div class="divTableBody">
            <%--first row--%>
            <div class="divTableRow newRow">
                <div class="divTableCell">
                    <input type="date" name="date">
                </div>
                <div class="divTableCell">
                    <input type="number" name="weight">
                </div>
                <div class="divTableCell">
                    <input type="number" name="waist">
                </div>
                <div class="divTableCell">
                    <img class="icon edit" src="img/checkmark-24.png">
                </div>
            </div>

            {{#each this}}
                <%--<li>{{this}}</li>--%>
                <div class="divTableRow">
                    <div class="divTableCell">{{this.measurementId.date}}</div>
                    <div class="divTableCell">
                        <input type="number" name="weight" value="{{this.weight}}" readonly>
                    </div>
                    <div class="divTableCell">
                        <input type="number" name="waist" value="{{this.waist}}" readonly>
                    </div>
                    <div class="divTableCell">
                        <img class="icon edit" src="img/new-24.png">
                        <img class="icon remove" src="img/cross-24.png">
                    </div>
                </div>
            {{/each}}
        </div>
    </div>
</script>

<!-- DivTable.com -->
<div id="container">
    <div id="table"></div>
    <div id="chart"></div>
</div>
</body>
</html>