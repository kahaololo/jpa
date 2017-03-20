/**
 * Created by skokhanenko on 17.03.2017.
 */
routes.chart = function(id, action) {
    if (AuthService.getInstance().isUserLoggedIn()) {
        mount('chart-page');
    } else {
        route('login', 'Prohibited', true);
    }
};