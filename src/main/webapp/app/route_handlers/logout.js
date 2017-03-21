/**
 * Created by skokhanenko on 17.03.2017.
 */
routes.logout = function() {
    authService.logout();
    route('welcome');
};