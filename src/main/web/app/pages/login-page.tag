<login-page>
    <div class="container">

        <form class="form-signin" id="loginForm" onsubmit={submit}>
            <h2 class="form-signin-heading">Please sign in</h2>
            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" ref="email" required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" ref="password" required>

            <div class="checkbox">
                <label>
                    <input type="checkbox" name="save" ref="save"> Remember me
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>

    </div>
    <!-- /container -->
    <style>
        .form-signin {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin .checkbox {
            font-weight: normal;
        }

        .form-signin .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }

        .form-signin .form-control:focus {
            z-index: 2;
        }

        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }

        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
    </style>

    <script>
        let tag = this;
        tag.submit = function(e) {
            e.preventDefault();

            let save = tag.refs.save.checked ? 1 : 0;

            let formData = new FormData();
            formData.append("email", tag.refs.email.value);
            formData.append("password", tag.refs.password.value);

            var request = $.ajax({
                method: "POST",
                url: "/rest/authentication",
                dataType: 'json',
                processData: false,
                contentType: "application/json",
                data: formData,
                statusCode: {
                    401: function(response) {
                        console.log(response);
//                        displayError("wrongPasswordMessage", response.responseText);
                    }
                }
            });

            request.done(function(rs) {
                tag.opts.authService.login(rs.authToken, rs.expires, save);
            });


//            route('welcome');
        }
    </script>
</login-page>


