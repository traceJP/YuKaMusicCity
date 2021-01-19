package com.tracejp.yuka.service;

import com.tracejp.yuka.model.pojo.RegisteredParameterPOJO;

import javax.servlet.http.HttpSession;

/*********************************
 * @author traceJP
 *********************************/
public interface UserAdminService {

    /**
     * 自动登录功能session保存时间 7天
     */
    int AUTO_LOGIN_SESSION_TIME = 7 * 3600;

    /**
     * 用户令牌session过期时间（毫秒）
     */
    int TOKEN_SESSION_EXPIRED_TIME = 24 * 3600 * 1000;

    /**
     * 用户注册服务
     *
     * @param param 前端参数传递
     * @return 返回一个响应状态码
     * 200ok  400注册失败  408超时
     */
    String registered(RegisteredParameterPOJO param);

    /**
     * 用户登录服务
     * @param email
     * @param password
     * @param isAutoLogin
     * @param session
     * @return 200ok 400登录失败
     */
    String loginAttest(String email, String password, boolean isAutoLogin, HttpSession session);

    /**
     * 密码修改服务
     * @param password 前端传递密码参数
     * @return 返回一个响应状态码
     */
    String updatePassword(String password);

}
