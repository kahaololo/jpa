/**
 * Created by skokhanenko on 17.03.2017.
 */
class AuthService {
    constructor(obs) {
        this.observable = obs;
        this.user = new User();
        $.ajaxSetup({headers: { 'Authorization': this.user.token().key() }});
    }

    isUserLoggedIn() {
        return this.user.token().isValid();
    }

    login(key, date, save) {
        this.user.token(new Token(key, date));

        var storage = save ? localStorage : sessionStorage;

        this.user.save(storage);

        this.observable.trigger("logIn");
    }

    getUser() {
        return this.user;
    }

    logout() {
        this.user.destroy();

        this.observable.trigger("logOut");
    }

}

