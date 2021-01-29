package com.tracejp.yuka.interceptor;

import com.tracejp.yuka.model.enums.ResponseStatus;
import com.tracejp.yuka.service.UserAdminService;
import com.tracejp.yuka.service.UserLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*********************************
 * @author traceJP
 *********************************/
public class UserAttestInterceptor implements HandlerInterceptor {

    @Autowired
    private UserAdminService adminService;
    @Autowired
    private UserLevelService levelService;

    /**
     * 自动登录
     * 用于一切与用户资源请求的拦截
     * 主要验证session中是否存在用户id
     * 存在 -> 通过
     * 不存在 -> 直接响应状态码 FAIL_LOGIN_INTERCEPT
     * @param request request
     * @param response response
     * @param handler handler
     * @return 是否放行
     * @throws Exception Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String sessionUid = (String) session.getAttribute("uid");
        if(sessionUid == null) {
            // 未登录过的页面请求全部直接响应状态码1005
            response.getWriter().write(ResponseStatus.FAIL_LOGIN_INTERCEPT.getStatus());
        }
        // 已登录：进行各种检查项
        request.setAttribute("uid", sessionUid);
        toDayFirstLogin(request, response, sessionUid);
        adminService.replaceLoginTime(sessionUid);
        return true;
    }

    /**
     * 对所有资源请求都进行当天是否第一次登录检查
     * @param request request
     * @param response response
     * @param uid uid
     */
    private void toDayFirstLogin(HttpServletRequest request, HttpServletResponse response, String uid) {
        // 存在缓存时，不执行每天第一次登录查询
        Cookie[] cookies = request.getCookies();
        String cookieValue = "true";
        String cookieName = "firstCache";
        for(Cookie cookie : cookies) {
            if(cookieName.equals(cookie.getName()) && cookieValue.equals(cookie.getValue())) {
                return;
            }
        }
        // 执行第一次登录检查
        if(adminService.isTodayFirstLogin(uid)) {
            levelService.addLoginDays(uid);
            adminService.setFirstLoginCache(response);
        }
    }

}
