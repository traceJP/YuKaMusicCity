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
    // 未登录拦截
    FAIL_LOGIN_INTERCEPT("1005"),
    // 业务响应成功
    SUCCESS_200("200"),
    // 业务响应失败
    SUCCESS_ERROR("404");

    private final String value;

    ResponseStatus(String value) {
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
