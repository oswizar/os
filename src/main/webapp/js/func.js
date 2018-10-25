//注册
function addUser() {

    var username = $("#name").val();
    var password = $("#password").val();
    if(!username){
        alert("账号不能为空");
    }
    else if (!password){
        alert("密码不能为空");
    }
    else {
        var user = {
            "name": username,
            "password": password,
        };
        var _url = "http://localhost:8080/os/user/showUser";
        $.ajax({
            url: _url,
            type: "POST",
            data: JSON.stringify(user),
            contentType: "application/json;charset=utf-8",

            success: function (data) {
                if(data!="注册成功"){
                    alert(data);
                }
                else {//注册成功
                    alert(data);
                    window.location.href = "http://localhost:8080/os/user_index.html";
                }
            }
        });
    }

}

//登录
function loginUser() {
    var username = $("#name").val();
    var password = $("#password").val();
    if(!username){
        alert("账号不能为空");
    }
    else if (!password){
        alert("密码不能为空");
    }else {
        var user = {
            "name": username,
            "password": password,
        };
        var _url = "http://localhost:8080/os/user/loginUser";
        $.ajax({
            url: _url,
            type: "POST",
            data: JSON.stringify(user),
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                var msg = data.msg;
                if(msg!="登录成功"){
                    alert(msg);

                }
                else {//登录成功
                    alert(msg);
                    window.location.href = "http://localhost:8080/os/user_ing.html";
                }
            }
        });
    }


}

//修改
function updateUser() {
    var username = $("#name").val();
    var password = $("#password").val();
    var user = {
        "id": $("#id").val(),
        "username": $("#username").val(),
        "password": $("#password").val(),
        "email": $("#email").val(),
        "role": $("#role").val(),
        "status": $("#status").val(),
        "regTime": new Date(),
        "regIp": $("#regIp").val()
    };
    console.log(user);
    var _url = "http://localhost:8080/os/user/updateUser";
    $.ajax({
        url: _url,
        type: "POST",
        data: user,
        contentType: "application/x-www-form-urlencoded",
    }).done(function (data) {
        window.location.replace("http://localhost:8080/os/user_info.html");
    }).fail(function (res) {
        window.location.replace("http://localhost:8080/os/user_info.html");
    });
}

//删除
function removeUser(id) {
    var _url = "http://localhost:8080/os/user/removeUser";
    alert("第" + id + "条数据已被删除！");
    $.ajax({
        type: "DELETE",
        url: _url + "/" + id,
        dataType: "json",
        success: function (data) {
            window.location.reload();
        },
        error: function (res) {
            window.location.reload();
        }
    });
}

//退出
function removeSession() {
    window.sessionStorage.removeItem("user");
}