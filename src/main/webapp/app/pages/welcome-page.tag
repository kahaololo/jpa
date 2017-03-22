<welcome-page>
    <div if={ ! this.isLoggedIn }>
        you are not logged in. please follow by the link to login.
        <h1><a class="mdl-navigation__link" href="#login">press for login</a></h1>
    </div>

    <div if={ this.isLoggedIn }>
        <h1>welcome</h1>
    </div>

    <script>
        this.isLoggedIn = this.opts.isLoggedIn;
    </script>

</welcome-page>