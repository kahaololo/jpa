<login-page>
    <div class="container">

        <div class="form">
            <form id="logInForm" onsubmit="{logIn}">
                <input placeholder="Please enter password" id="password" name="password" type="password" ref="password" required/>
                &nbsp;
                <input type="submit" value="go!">
                <br>
                <input class="save" type="checkbox" name="save" id="save">
                <label class="save" for="save">Save on this machine</label>
            </form>
        </div>

    </div>
    <!-- /container -->
    <style>
        div.container {
            padding-top: 25%;
        }

        div.form {
            display: inline-block;
        }

        input[type="password"] {
            outline: 0;
            border-width: 0 0 2px 0;
            border-color: blue
        }

        input[type="password"]:focus {
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

        .save {
            float: left;
            font-size: small;
            color: #242552;
        }
        label.save {
            padding-left: 5px;
            padding-top: 2px;
        }
    </style>

    <script>
        let tag = this;
        tag.logIn = function(e) {
            e.preventDefault();

            console.log("login");
            return false;
            let save = tag.refs.save.checked ? 1 : 0;

//            let formData = $('#loginForm').serializeArray().reduce(function(a, x) { a[x.name] = x.value; return a; }, {});

            var request = $.ajax({
                method: "POST",
                url: "/rest/user/authenticate",
                dataType: 'json',
                processData: false,
                contentType: "application/json",
                data: JSON.stringify( formData ),
                statusCode: {
                    401: function(response) {
                        console.log(response);
                        displayError("wrongPasswordMessage", response.responseText);
                    }
                }
            });

            request.done(function(rs) {
                tag.opts.authService.login(rs.authToken, rs.expires, save);
                route('welcome');
            });
        }
    </script>
</login-page>


