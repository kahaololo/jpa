$(function () {

    $('input[type="submit"]').mousedown(function () {
        $(this).css('background', '#2ecc71');
    });
    $('input[type="submit"]').mouseup(function () {
        $(this).css('background', '#1abc9c');
    });

    $('#loginform').on('click', function () {
        $('.register').hide();
        $('.login').show("slow");
        $(this).toggleClass('green');
    });

    $('#registerform').on('click', function () {
        $('.login').hide();
        $('.register').show("slow");
        $(this).toggleClass('green');
    });


    $(document).mouseup(function (e) {
        var container = $(".login");

        if (!container.is(e.target) // if the target of the click isn't the container...
            && container.has(e.target).length === 0) // ... nor a descendant of the container
        {
            container.hide();
            $('#loginform').removeClass('green');
        }
    });

});