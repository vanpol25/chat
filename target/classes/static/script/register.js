$(document).ready(() => {
    $("#submit").click(() => {
        let request = {
            username: $("#username").val(),
            password: $("#password").val()
        };
        console.log(request.username);
        console.log(request.password);
        $.ajax({
            url: "http://localhost:8080/user/register",
            contentType: 'application/json',
            type: "post",
            data: JSON.stringify(request),
            success: () => {
                console.log("Created user with username - " + request.username)
            }
        })
    });
});