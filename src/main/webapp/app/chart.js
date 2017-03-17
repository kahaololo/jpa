/**
 * Created by skokhanenko on 17.03.2017.
 */
routes.chart = function(id, action) {
    if (! AuthService.isUserLoggedIn())
        route('login', 'Prohibited', true);
    mount('chart-page');
};