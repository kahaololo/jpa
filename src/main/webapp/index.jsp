<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <script src="http://code.jquery.com/jquery-2.2.0.min.js"></script>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.17.1/moment.min.js"></script>
    <script src="js/main.js"></script>
    <script src="js/handlebars.js"></script>
    <script src="js/form.js"></script>
    <link rel="stylesheet" type="text/css" href="css/table.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/form.css">

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
                    <img class="icon add" src="img/checkmark-24.png">
                </div>
            </div>

            {{#each this}}
            <%--<li>{{this}}</li>--%>
            <div class="divTableRow" data-index="{{@index}}">
                <div class="divTableCell">{{dateformat this.measurementId.date}}</div>
                <div class="divTableCell">
                    <input type="number" name="weight" value="{{this.weight}}">
                </div>
                <div class="divTableCell">
                    <input type="number" name="waist" value="{{this.waist}}">
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

<script id="login-template" type="text/x-handlebars-template">

    <div id="wrap">
        <div id="regbar">
            <div id="navthing">
                <h2><a href="javascript:void(0)" id="loginform">Login</a> | <a href="javascript:void(0)" id="registerform">Register</a></h2>

                <div class="login">
                    <div class="arrow-up-login"></div>
                    <div class="formholder">
                        <div class="randompad">
                            <fieldset>
                                <label name="email">Email</label>
                                <input type="email" value="example@example.com"/>
                                <label name="password">Password</label>
                                <input type="password"/>
                                <input type="submit" value="Login"/>
                            </fieldset>
                        </div>
                    </div>
                </div>

                <div class="register">
                    <div class="arrow-up-register"></div>
                    <div class="formholder">
                        <div class="randompad">
                            <fieldset>
                                <label name="email">Email</label>
                                <input type="email" value="example@example.com"/>
                                <label name="password">Password</label>
                                <input type="password"/>
                                <label name="passwordConfirmation">Confirm password</label>
                                <input type="password"/>
                                <input type="submit" value="Register"/>
                            </fieldset>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</script>

<!-- DivTable.com -->
<div id="container">
    <div id="form"></div>
    <div id="table"></div>
    <div id="chart"></div>
</div>
</body>
</html>