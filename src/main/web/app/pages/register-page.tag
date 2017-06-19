<register-page>
    <div class="container">

        <form class="form-register" id="registerForm" onsubmit={submit}>
            <h3 class="form-register-heading">Please fill form</h3>

            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" ref="email" required autofocus>

            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" ref="password" required>

            <label for="inputUserName" class="sr-only">User Name</label>
            <input type="text" name="name" id="inputUserName" class="form-control" placeholder="username" ref="username" required>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
        </form>

    </div>
    <!-- /container -->
    <style>
        .form-register {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }

        .form-register .form-register-heading,
        .form-register .checkbox {
            margin-bottom: 10px;
        }

        .form-register .checkbox {
            font-weight: normal;
        }

        .form-register .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }

        .form-register .form-control:focus {
            z-index: 2;
        }

        .form-register input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }

        .form-register input[type="password"] {
            margin-bottom: -1px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }

        .form-register input[type = "text"] {
            margin-bottom: 20px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
    </style>

    <script>
        let tag = this;
        tag.submit = function(e) {
            e.preventDefault();

            let formData = $('#registerForm').serializeArray().reduce(function(a, x) { a[x.name] = x.value; return a; }, {});

            $.ajax({
                method: "POST",
                url: "/rest/user/register",
                dataType: 'json',
                processData: false,
                contentType: "application/json",
                data: JSON.stringify( formData ),
                statusCode: {
                    200: function (rs) {
                        route('welcome');
                    },
                    400: function(response) {
                        console.log(response);
                        Utils.notify("danger", response.responseText);
                    },
                },
            });
        }
    </script>
</register-page>


