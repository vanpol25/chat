$(document).ready(function () {
    $("#login").click(() => {
        console.log("click");
        let request = {
            username: $("#username").val(),
            password: $("#password").val()
        };
        console.log(request.username);
        console.log(request.password);
        $.ajax({
            url: "http://localhost:8080/user/login",
            contentType: 'application/json',
            type: "post",
            data: JSON.stringify(request),
            success: (response) => {
                console.log(response.token);
                $.ajax({
                    url: "http://localhost:8080/user/getName",
                    type: "get",
                    headers: {
                        'Authorization': `Bearer ${response.token}`,
                    },
                    success: (res) => {
                        console.log(res)
                    },
                    error: (e) => {
                        console.error(e);
                    }
                });
            }
        });

    });
});