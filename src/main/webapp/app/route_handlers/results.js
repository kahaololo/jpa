/**
 * Created by skokhanenko on 17.03.2017.
 */
routes.results = function() {
    if (AuthService.getInstance().isUserLoggedIn())
        mount('results-page');
    else
        route('login', 'Prohibited', true);
}