function User(name, email, token) {
    this._name = name || sessionStorage.getItem("name") || localStorage.getItem("name") || null;
    this._email = email || sessionStorage.getItem("email") || localStorage.getItem("email") || null;
    this._token = new Token();
}

User.prototype.save = function (storage) {
    if (! storage)
        return false;
    storage.setItem("name", this._name);
    storage.setItem("email", this._email);
    this._token.save(storage);
};

User.prototype.destroy = function () {
    this._token.erase();

    [localStorage, sessionStorage].forEach(function(storage){
        storage.removeItem("name");
        storage.removeItem("email");
    });
};

User.prototype.name = function (name) {
    if (arguments.length != 0)
        this._name = name;

    return this._name;
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