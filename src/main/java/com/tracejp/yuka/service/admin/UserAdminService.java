package com.tracejp.yuka.service.admin;

import com.tracejp.yuka.model.dto.RegisteredParameterDTO;

import javax.servlet.http.HttpServletResponse;
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
     * 获取用户名服务
     * @param session 通过session获取uid
     * @return 用户名userName
     */
    String getUserName(HttpSession session);

    /**
     * 获取用户头像服务
     * @param session 通过session获取uid
     * @return 头像url
     */
    String getUserAvatar(HttpSession session);

    /**
     * 用户注册服务
     *
     * @param param 前端参数传递
     * @return 返回一个响应状态码
     * 200ok  400注册失败  408超时
     */
    String registered(RegisteredParameterDTO param);

    /**
     * 用户登录服务（只适用于login.html页面）
     * @param email 邮箱
     * @param password 密码
     * @param isAutoLogin 是否自动登录
     * @param session session
     * @return 200ok 400登录失败
     */
    String loginAttest(String email, String password, Boolean isAutoLogin, HttpSession session);

    /**
     * 用户登录退出服务
     * @param session
     * @return
     */
    String loginExit(HttpSession session);

    /**
     * 是否存在相同email，需要操作返回json数据
     * @param email 传入email值
     * @return json: {"valid":boolean}   ***返回true表示可以通过
     */
    String hasSameEmail(String email);

    /**
     * 判断是否当天第一次登录
     * @param uid uid
     * @return 当天未登录则返回true
     */
    boolean isTodayFirstLogin(String uid);

    /**
     * 设置当天首次登录的缓存
     * @param resp resp
     */
    void setFirstLoginCache(HttpServletResponse resp);

    /**
     * 更新用户的最后登录时间
     * @param uid uid
     */
    void replaceLoginTime(String uid);

}
