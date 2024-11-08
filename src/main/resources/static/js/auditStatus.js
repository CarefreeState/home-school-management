function getAuditStatus(auditStatus) {
    var type = "";
    switch (auditStatus) {
        case 0:
            type = "未审核";
            break;
        case 1:
            type = "审核通过";
            break;
        case 2:
            type = "审核不通过";
            break;
        default:
            break;
    }
    return type;
}
