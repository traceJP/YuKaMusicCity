package com.tracejp.yuka.service;

import com.tracejp.yuka.model.dto.RegisteredParameterDTO;

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
     * 用户注册服务
     *
     * @param param 前端参数传递
     * @return 返回一个响应状态码
     * 200ok  400注册失败  408超时
     */
    String registered(RegisteredParameterDTO param);

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
     * @param uid
     * @return 返回一个响应状态码
     */
    String updatePassword(String uid, String password);

}
