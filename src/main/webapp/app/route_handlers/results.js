/**
 * Created by skokhanenko on 17.03.2017.
 */
routes.results = function () {
    if (authService.isUserLoggedIn())
        mount('results-page', {observable: obs});
    else
        route('login', 'Prohibited', true);
}