function jsonRequestWithToken(u, m, d, s) {
    jQuery.ajax({
        url: u,
        method: m,
        contentType: "application/json; charset=utf8",
        headers: {
            "token": getToken(),
        },
        data: JSON.stringify(d),
        success: function (body) {
            if (body.code === 200) {
                s(body.data);
            } else {
                jQuery.toast({
                    heading: "异常",
                    text: body.message,
                    icon: "warning",
                    allowToastClose: true,
                });
                if(body.code === 2001) {
                    toLogin();
                }
            }
        },
        error: function () {
            //提示信息
            $.toast({
                heading: "错误",
                text: "访问出现问题 ",
                icon: "error",
                allowToastClose: true,
            });
        },
        complete: function(xhr) {
            setToken(xhr.getResponseHeader("token"));
        },
    });
}

function jsonRequest(u, m, d, s) {
    jQuery.ajax({
        url: u,
        method: m,
        contentType: "application/json; charset=utf8",
        data: JSON.stringify(d),
        // 3. 处理响应
        success: function (body) {
            if (body.code === 200) {
                s(body.data);
            } else {
                jQuery.toast({
                    heading: "异常",
                    text: body.message,
                    icon: "warning",
                    allowToastClose: true,
                });
            }
        },
        error: function () {
            //提示信息
            $.toast({
                heading: "错误",
                text: "访问出现问题 ",
                icon: "error",
                allowToastClose: true,
            });
        },
    });
}


