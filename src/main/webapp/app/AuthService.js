/**
 * Created by skokhanenko on 17.03.2017.
 */

var AuthService = (function () {

    // Instance stores a reference to the Singleton
    var instance;

    function init() {
        var token = new Token();

        function isUserLoggedIn() {
            return token.isValid();
        }

        function getUserName() {
            return null;
        }

        function login(key, date, save) {
            token = new Token(key, date);

            var storage = save ? localStorage : sessionStorage;

            storage.setItem("key", key);
            storage.setItem("date", date);
        }

        function logout() {
            token.erase();

            [localStorage, sessionStorage].forEach(function(storage){
                storage.removeItem("key");
                storage.removeItem("date");
            });
        }

        return {
            isUserLoggedIn: isUserLoggedIn,
            getUserName: getUserName,
            login: login,
            logout: logout
        };
    }

    return {
        getInstance: function () {
            if ( !instance )
                instance = init();
            return instance;
        }
    };
})();
