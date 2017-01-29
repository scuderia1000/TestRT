$(document).ready(function () {
    $('#search').click(function () {
        var lastName = $('#lastName').val();
        var firstName = $('#firstName').val();
        var middleName = $('#middleName').val();
        var city = $('#city').val();
        var car = $('#car').val();
        if ((lastName == null || lastName == "") && (firstName == null || firstName == "")
            && (middleName == null || middleName == "") && (city == null || city == "")
            && (car == null || car == "")) {
            alert("Пожалуйста, заполните хотя бы одно поле!");
            return false;
        }
        $.ajax({
            url: 'getUserServlet',
            data: {
                lastName: lastName,
                firstName: firstName,
                middleName: middleName,
                city: city,
                car: car
            },
            success: function (response) {
                $("tr:has(td)").remove();

                $.each(response, function (key, user) {
                    var td_cars = $("<td/>");
                    $.each(user.carModels, function (index, model) {
                        var span = $("<span class='label label-info' style='margin:4px;padding:4px' />");
                        span.text(model);
                        td_cars.append(span);
                    });
                    $("#users").append($("<tr/>")
                        .append($("<td/>").text(user.lastName))
                        .append($("<td/>").text(user.firstName))
                        .append($("<td/>").text(user.middleName))
                        .append($("<td/>").text(user.city))
                        .append(td_cars)
                    );
                });
            }
        });
    });
    $('#usersSearch').keypress(function(e){
        if(e.which == 13) {
            $('#search').click();
        }
    });
});
// }