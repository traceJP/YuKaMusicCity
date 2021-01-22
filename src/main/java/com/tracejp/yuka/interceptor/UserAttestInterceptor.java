package com.tracejp.yuka.interceptor;

import com.tracejp.yuka.model.enums.ResponseStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*********************************
 * @author traceJP
 *********************************/
public class UserAttestInterceptor implements HandlerInterceptor {

    /**
     * 自动登录
     * 用于一切与用户资源请求的拦截
     * 主要验证session中是否存在用户信息
     * 存在 -> 通过
     * 不存在 -> 直接响应状态码 FAIL_LOGIN_INTERCEPT
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String sessionUid = (String) session.getAttribute("uid");
        String sessionPassword = (String) session.getAttribute("password");
        if(sessionUid == null || sessionPassword == null) {
            response.getWriter().write(ResponseStatus.FAIL_LOGIN_INTERCEPT.getStatus());
        }
        return true;
    }

}