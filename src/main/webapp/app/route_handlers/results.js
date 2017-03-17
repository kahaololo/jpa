/**
 * Created by skokhanenko on 17.03.2017.
 */
routes.results = function() {
    if (! AuthService.isUserLoggedIn())
        route('login', 'Prohibited', true);
    mount('results-page');
}