/**
 * Created by skokhanenko on 23.03.2017.
 */
class Utils {
    constructor(){}

    static notify(type, message) {
        $.notify(message, {
            type: type,
            allow_dismiss: false,
            placement: {
                from: "bottom",
                align: "center"
            },
            delay: 1000,
            offset: {
                y: 50
            }
        });
    }
}