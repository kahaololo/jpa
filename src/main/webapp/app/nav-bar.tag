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
                <a class="navbar-brand" href="#welcome">Hello { getUserName() || "John Dou"} !!!</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul if={ isUserLoggedIn() } class="nav navbar-nav">
                    <li><a href="#chart">Chart</a></li>
                    <li><a href="#results">Results</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li if={ ! isUserLoggedIn() }><a href="#login">Sign In</a></li>
                    <li if={ isUserLoggedIn() }><a href="#logout">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>



    <script>
    </script>

</nav-bar>