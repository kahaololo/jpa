/**
 * Created by skokhanenko on 17.03.2017.
 */

var AuthService = (function () {
    function isUserLoggedIn() {
        return localStorage.getItem("key") != null && localStorage.getItem("key").length && localStorage.getItem("date");
    }

    function getUserName() {
        return null;
    }

    function login(key, date) {
        localStorage.setItem("key", key);
        localStorage.setItem("date", date);
    }

    function logout() {
        localStorage.removeItem("key");
        localStorage.removeItem("datekey");
    }

    return {
        isUserLoggedIn: isUserLoggedIn,
        getUserName: getUserName,
        login: login,
        logout: logout
    };
}());