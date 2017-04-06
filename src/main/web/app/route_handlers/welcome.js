/**
 * Created by skokhanenko on 28.02.2017.
 */

'use strict';

routes.welcome = function(id, action) {
    mount('welcome-page', {
        observable: obs,
        isLoggedIn: authService.isUserLoggedIn(),
        userName: authService.getUserName(),
        measurementService: measurementService
    });
};