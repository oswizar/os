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
                var msg=data.msg;//注册失败
                if(msg!="注册成功"){
                    alert(msg);
                }
                else {//注册成功
                    alert(msg);
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
                var msg=data.msg;
                var  user=data.user;
                if(msg!="登录成功"){//登录失败
                    alert(msg);
                }
                else {//登录成功
                    alert(msg);
                    window.sessionStorage.setItem("user", JSON.stringify(user));
                    window.location.replace("http://localhost:8080/os/user_ing.html");//不能返回上个页面
                    //window.location.href= "http://localhost:8080/os/user_ing.html";//能返回上个页面
                }
            }
        });
    }
}

//修改
function updateUser() {
    var id = $("#id").val();
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
            "id": id,
            "name": username,
            "password": password,
        };
        var _url = "http://localhost:8080/os/user/updateUser";
        $.ajax({
            url: _url,
            type: "POST",
            data: JSON.stringify(user),
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                var msg = data.msg;
                if(msg!="修改成功"){
                    alert(msg);
                }
                else {
                    alert(msg);
                    removeSession();
                    window.location.replace("http://localhost:8080/os/user_index.html");
                }
            }

        });
    }

}

//查询所有用户
function showUser() {
    console.log('111111111')
    var _url = "http://localhost:8080/os/user/allUser";
    $.ajax({
        url: _url,
        type:"POST",
        // data: {},
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            var list = data;
            console.log(list)
            if(list!=null){
                for(var i = 0;i<list.length;i++){
                    $("#showUser").append(
                        ' <tr>' +
                        '<th>list[i].id</th>' +
                        '<th>list[i].name</th>' +
                        '<th>list[i].password</th>' +
                        '</tr>'
                    );
                }
            }
        }
    });

}


//删除
function removeUser() {
    var _url = "http://localhost:8080/os/user/removeUser";
    alert("第" + id + "条数据已被删除！");
    $.ajax({
        type: "POST",
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