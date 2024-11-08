function toLogin() {
    jQuery.toast({
        heading: "提示",
        text: "前往登录",
        icon: "info",
        allowToastClose: true,
    });
    setTimeout(function () {
        location.href = "../login.html";
    }, 3000);
}

function toSystemMessageList() {
    jQuery.toast({
        heading: "提示",
        text: "前往系统消息",
        icon: "info",
        allowToastClose: true,
    });
    setTimeout(function () {
        location.href = "../system_message_list.html";
    }, 3000);
}

function toClassMessageList() {
    jQuery.toast({
        heading: "提示",
        text: "前往班级消息",
        icon: "info",
        allowToastClose: true,
    });
    setTimeout(function () {
        location.href = "../class_message_list.html";
    }, 3000);
}

function toSiteMessageList() {
    jQuery.toast({
        heading: "提示",
        text: "前往站内信",
        icon: "info",
        allowToastClose: true,
    });
    setTimeout(function () {
        location.href = "../site_message_list.html";
    }, 3000);
}


function toSystemMessageDetail(messageId) {
    jQuery.toast({
        heading: "提示",
        text: "前往系统消息详情",
        icon: "info",
        allowToastClose: true,
    });
    setTimeout(function () {
        location.href = "../system_message_detail.html?messageId=" + messageId;
    }, 3000);
}

function toClassMessageDetail(messageId) {
    jQuery.toast({
        heading: "提示",
        text: "前往班级消息详情",
        icon: "info",
        allowToastClose: true,
    });
    setTimeout(function () {
        location.href = "../class_message_detail.html?messageId=" + messageId;
    }, 3000);
}
function toSiteMessageDetail(messageId) {
    jQuery.toast({
        heading: "提示",
        text: "前往站内信详情",
        icon: "info",
        allowToastClose: true,
    });
    setTimeout(function () {
        location.href = "../site_message_detail.html?messageId=" + messageId;
    }, 3000);
}

function toClassDetail(classId) {
    jQuery.toast({
        heading: "提示",
        text: "前往班级详情",
        icon: "info",
        allowToastClose: true,
    });
    setTimeout(function () {
        location.href = "../class_detail.html?classId=" + classId;
    }, 3000);
}

function refresh() {
    location.href = location.href;
}