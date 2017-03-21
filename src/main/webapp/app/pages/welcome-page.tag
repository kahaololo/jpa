<welcome-page>
    <div if={ ! this.isLoggedIn }>
        you are not logged in. please follow by the link to login.
        <h1><a class="mdl-navigation__link" href="#login">press for login</a></h1>
    </div>

    <div if={ this.isLoggedIn }>
        <h1>welcome</h1>
    </div>

    <script>
        var tag = this;
        tag.isLoggedIn = opts.isLoggedIn;

        tag.opts.observable.on("logIn", function () {
            tag.isLoggedIn = true;
            tag.update();
        });

        tag.opts.observable.on("logOut", function () {
            tag.isLoggedIn = false;
            tag.update();
        });
    </script>

</welcome-page>