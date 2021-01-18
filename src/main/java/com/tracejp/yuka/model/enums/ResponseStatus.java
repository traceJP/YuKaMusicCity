package com.tracejp.yuka.model.enums;

/*********************************
 * @author traceJP
 *********************************/
public enum ResponseStatus {

    // 前端传入参数不完整
    FAIL_PARAM_IS_NULL(1001),
    // 前端参数传递类型错误
    FAIL_PARAM_TYPE_ERROR(1002),
    FAIL_EMAIL_PARAM_SAME(1003);

    private final int value;

    private ResponseStatus(int value) {
        this.value = value;
    }

    public int getStatus() {
        return value;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
