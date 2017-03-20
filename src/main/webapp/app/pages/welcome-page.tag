<welcome-page>
    <div if={ ! AuthService.getInstance().isUserLoggedIn() }>
        you are not logged in. please follow by the link to login.
        <h1><a class="mdl-navigation__link" href="#login">press for login</a></h1>
    </div>

    <div if={ AuthService.getInstance().isUserLoggedIn() }>
        <h1>welcome</h1>
    </div>

</welcome-page>