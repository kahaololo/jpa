/**
 * Created by skokhanenko on 20.03.2017.
 */
function Token(key, expiresAt) {
    this._key = key || sessionStorage.getItem("key") || localStorage.getItem("key") || null;
    this._expiresAt = expiresAt || sessionStorage.getItem("date") || localStorage.getItem("date") || null;
    this._userName = "Kaha";
}

Token.prototype.getUserName = function() {
    return this._userName;
};

Token.prototype.key = function(key) {
    if (arguments.length == 0)
        this._key = key;

    return this._key;
};

Token.prototype.expiresAt = function(date) {
    if (arguments.length == 0)
        this._expiresAt = date;

    return this._expiresAt;
};

Token.prototype.isValid = function() {
    return this._key != null && this._key.length && this._expiresAt != null;
};

Token.prototype.erase = function() {
    this._key = null;
    this._expiresAt = null;
};