/**
 * Created by skokhanenko on 17.03.2017.
 */

var AuthService = (function () {
    var userLoggedIn = false;

    function isUserLoggedIn() {
        return userLoggedIn;
    }

    function getUserName() {
        return null;
    }

    function setUserLoggedIn(boolean) {
        userLoggedIn = boolean ? true : false;
    }

    return {
        isUserLoggedIn: isUserLoggedIn,
        getUserName: getUserName,
        setUserLoggedIn: setUserLoggedIn
    };
}());