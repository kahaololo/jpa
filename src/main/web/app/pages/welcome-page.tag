<welcome-page>
    <div class="container">
        <div if={ ! this.isLoggedIn }>
            <div class="form">
                <form id="emailForm" onsubmit="{lookup}">
                    <input placeholder="Please enter your email" id="email" name="email" type="email" ref="email" required/>
                    &nbsp;
                    <input type="submit" value="go!">
                    <br>
                </form>
                <a href="/#register">Register new user.</a>
            </div>
        </div>

        <div if={ this.isLoggedIn }>

            <div class="row">
                <div class="col-sm-12">
                    <statistics></statistics>
                </div>
            </div>

        </div>
    </div>

    <script>
        let authService = this.opts.authService;
        this.isLoggedIn = authService.isUserLoggedIn();

        let tag = this;

        tag.lookup = function (e) {
            e.preventDefault();

            let email = tag.refs.email.value;

            var request = $.ajax({
                method: "POST",
                url: "/rest/user/lookup",
                dataType: 'json',
                processData: false,
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                data: $("#emailForm").serialize(),
                statusCode: {
                    400: function (response) {
                        $("#email").css("border-color", "red");
                        Utils.notify("danger", response.responseText);
                    }
                }
            });

            request.done(function (user) {
                console.log(user);
//                welcome user by name
                authService.getUser().email(user.email);
                authService.getUser().name(user.name);
                route('login');
            });
        }
    </script>

    <style>
        div.container {
            padding-top: 25%;
        }

        div.form {
            display: inline-block;
        }

        input[type="email"] {
            outline: 0;
            border-width: 0 0 2px 0;
            border-color: blue
        }

        input[type="email"]:focus {
            border-color: green
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 8px 15px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.14);
        }

        input[type="submit"] {
            opacity: 0.8;
        }

        a {
            text-decoration: none;
            float: left;
            font-size: small;
            color: #242552;
            padding-top: 10px;
        }

        a:link {
            color: #000000;
            border-bottom: 1px solid #FF0000;
        }

        a:visited {
            color: #000000;
            border-bottom: 1px solid #C0C0C0;
        }

        a:hover {
            color: #000000;
            border-bottom: 1px dotted #6fbf73;
        }
    </style>

</welcome-page>