<nav-bar>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a if={ ! this.isLoggedIn } href="#welcome" class="navbar-brand" >Welcome into measurement control system</a>
                <a if={ this.isLoggedIn } href="#welcome" class="navbar-brand">Hi {this.userName}</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul if={ this.isLoggedIn } class="nav navbar-nav">
                    <li><a href="#chart">Chart</a></li>
                    <li><a href="#results">Results</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li if={ this.isLoggedIn }><a href="#logout">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <script>
        let authService = this.opts.authService;

        let tag = this;

        tag.isLoggedIn = authService.isUserLoggedIn() || false;

        tag.userName = authService.getUser().name();

        tag.opts.observable.on("logIn", function () {
            tag.isLoggedIn = true;
            tag.userName = authService.getUser().name();
            tag.update();
        });

        tag.opts.observable.on("logOut", function () {
            tag.isLoggedIn = false;
            tag.update();
        });
    </script>


</nav-bar>