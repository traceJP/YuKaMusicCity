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
     * 主要验证session中是否存在用户id
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
        if(sessionUid == null) {
            // 未登录过的页面请求全部直接响应状态码1005
            response.getWriter().write(ResponseStatus.FAIL_LOGIN_INTERCEPT.getStatus());
        }
        // 已登录则直接将uid放入request域中
        request.setAttribute("uid", sessionUid);
        // TODO: 2021/1/27 需要使登录天数+1
        return true;
    }

}
