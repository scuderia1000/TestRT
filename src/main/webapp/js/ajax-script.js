// $(document).ready(function() {
//     $('#userName').blur(function(event) {
//         var name = $('#userName').val();
//         $.get('GetUserServlet', {
//             userName : name
//         }, function(responseText) {
//             $('#ajaxGetUserServletResponse').text(responseText);
//         });
//     });
// });

$(document).ready(function() {
    $('#search').click(function() {
        $.ajax({
            url : 'getUserServlet',
            data : {
                lastName : $('#lastName').val(),
                firstName : $('#firstName').val(),
                middleName : $('#middleName').val(),
                city : $('#city').val()
            },
            success : function(responseText) {
                $('#ajaxGetUserServletResponse').text(responseText);
            }
        });
    });
});
