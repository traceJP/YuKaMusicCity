package com.tracejp.yuka.service;

import com.tracejp.yuka.model.pojo.LoginParameterObject;
import com.tracejp.yuka.model.pojo.RegisteredParameterObject;

/*********************************
 * @author traceJP
 *********************************/
public interface UserAdminService {

    /**
     * 用户令牌session过期时间（毫秒）
     */
    int TOKEN_SESSION_EXPIRED_TIME = 24 * 3600 * 1000;

    /**
     * 用户注册服务
     *
     * @param param 前端参数传递
     *
     * @return 返回一个响应状态码
     * 200ok  400注册失败  408超时
     */
    int registered(RegisteredParameterObject param);

    /**
     * 用户登录服务
     *
     * @param param 前端参数传递
     *
     * @return 200ok 400登录失败
     */
    int loginAttest(LoginParameterObject param);

    /**
     * 密码修改服务
     * @param password 前端传递密码参数
     * @return 返回一个响应状态码
     */
    int updatePassword(String password);

    /**
     * 将用户唯一标识加入session中，如果session中存在用户唯一标识则代表该用户已经登录
     * @param uid 用户唯一标识
     * @oaram password 用户密码
     */
    void setUserTokenSession(String uid, String password);

    /**
     * 根据用户唯一标识清除用户session
     * @param uid 用户唯一标识
     */
    void clearTokenSession(String uid);

}
