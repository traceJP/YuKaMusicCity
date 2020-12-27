$(function () {
    $('[data-toggle="popover-uid"]').popover()
})

// 表单验证注册
$(document).ready(function() {
    $('#formNickName').bootstrapValidator();
});
$(document).ready(function() {
    $('#formEmail').bootstrapValidator();
});
$(document).ready(function() {
    $('#formUpdataPassword').bootstrapValidator();
});
