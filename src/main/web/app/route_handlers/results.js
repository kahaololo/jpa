/**
 * Created by skokhanenko on 17.03.2017.
 */
routes.results = function () {
    if (authService.isUserLoggedIn())
        mount('results-page', {observable: obs, measurementService: measurementService});
    else
        route('login');
}