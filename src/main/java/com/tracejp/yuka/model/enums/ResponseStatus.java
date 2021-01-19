package com.tracejp.yuka.model.enums;

/*********************************
 * @author traceJP
 *********************************/
public enum ResponseStatus {

    // 前端传入参数不完整
    FAIL_PARAM_IS_NULL("1001"),
    // 前端参数传递类型错误
    FAIL_PARAM_TYPE_ERROR("1002"),
    // 注册传递邮箱相同
    FAIL_EMAIL_PARAM_SAME("1003"),
    // 登录失败账号或密码错误
    FAIL_LOGIN_INFO_ERROR("1004"),
    // 业务响应成功
    SUCCESS_200("200");

    private final String value;

    private ResponseStatus(String value) {
        this.value = value;
    }

    public String getStatus() {
        return value;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
