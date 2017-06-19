function User(username, email, token) {
    this._username = username || sessionStorage.getItem("username") || localStorage.getItem("username") || null;
    this._email = email || sessionStorage.getItem("email") || localStorage.getItem("email") || null;
    this._token = new Token();
}

User.prototype.save = function (storage) {
    if (! storage)
        return false;

    storage.setItem("username", this._username);
    storage.setItem("email", this._email);
    this.token().save(storage);
};

User.prototype.destroy = function () {
    this.user.token().erase();

    [localStorage, sessionStorage].forEach(function(storage){
        storage.removeItem("username");
        storage.removeItem("email");
    });
};

User.prototype.username = function (username) {
    if (arguments.length != 0)
        this._username = username;

    return this._username;
};

User.prototype.email = function (email) {
    if (arguments.length != 0)
        this._email = email;

    return this._email;
};

User.prototype.token = function (token) {
    if (arguments.length != 0)
        this._token = token;

    return this._token;
};