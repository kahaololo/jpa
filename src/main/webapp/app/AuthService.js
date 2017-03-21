/**
 * Created by skokhanenko on 17.03.2017.
 */
class AuthService {
    constructor(obs) {
        this.observable = obs;
        this.token = new Token();
    }

    isUserLoggedIn() {
        return this.token.isValid();
    }

    login(key, date, save) {
        this.token = new Token(key, date);

        var storage = save ? localStorage : sessionStorage;

        storage.setItem("key", key);
        storage.setItem("date", date);

        this.observable.trigger("logIn");
    }

    logout() {
        this.token.erase();

        [localStorage, sessionStorage].forEach(function(storage){
            storage.removeItem("key");
            storage.removeItem("date");
        });

        this.observable.trigger("logOut");
    }

}

