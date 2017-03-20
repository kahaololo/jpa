/**
 * Created by skokhanenko on 17.03.2017.
 */
routes.logout = function() {
    AuthService.getInstance().logout();
    riot.update();
    route('welcome');
};