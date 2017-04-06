<welcome-page>
    <div class="container">
        <div if={ ! this.isLoggedIn }>
            you are not logged in. please follow by the link to login.
            <h1><a class="mdl-navigation__link" href="#login">press for login</a></h1>
        </div>

        <div if={ this.isLoggedIn }>

            <div class="row">
                <div class="col-sm-12" >
                    <statistics></statistics>
                </div>
            </div>

        </div>
    </div>

    <script>
        this.isLoggedIn = this.opts.isLoggedIn;
        this.userName = this.opts.userName;
        this.measurementService = this.opts.measurementService;
    </script>

</welcome-page>