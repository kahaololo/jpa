/**
 * Created by skokhanenko on 17.03.2017.
 */
routes.chart = function(id, action) {
    if (authService.isUserLoggedIn()) {
        mount('chart-page', {observable: measurementService});
    } else {
        route('login', 'Prohibited', true);
    }
};