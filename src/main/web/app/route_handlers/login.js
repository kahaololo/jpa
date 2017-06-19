/**
 * Created by skokhanenko on 15.03.2017.
 */
routes.login = function(id, action) {
    if (authService.getUser().name())
        mount('login-page', {authService: authService});
    else
        route("welcome");
};