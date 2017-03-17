/**
 * Created by skokhanenko on 17.03.2017.
 */
routes.logout = function() {
    AuthService.setUserLoggedIn(false);
    riot.update();
    route('welcome');
}