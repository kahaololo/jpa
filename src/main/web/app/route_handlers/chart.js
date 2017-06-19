/**
 * Created by skokhanenko on 17.03.2017.
 */
routes.chart = function(id, action) {
    if (authService.isUserLoggedIn()) {
        mount('chart-page', {observable: obs, measurementService: measurementService});
    } else {
        route('login');
    }
};