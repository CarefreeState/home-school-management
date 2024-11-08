function getType(userType) {
    var type = "";
    switch (userType) {
        case 1:
            type = "管理员";
            break;
        case 2:
            type = "老师";
            break;
        case 3:
            type = "家长";
            break;
        default:
            break;
    }
    return type;
}
