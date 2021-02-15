package com.tracejp.yuka.service.admin.impl;

import com.tracejp.yuka.dao.UserAdminMapper;
import com.tracejp.yuka.model.enums.ResponseStatus;
import com.tracejp.yuka.model.dto.RegisteredParameterDTO;
import com.tracejp.yuka.service.admin.UserAdminService;
import com.tracejp.yuka.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.Date;

/*********************************
 * @author traceJP
 * 用户认证实现类
 *********************************/
@Service
public class UserAdminServiceImpl implements UserAdminService {

    /**
     * 随机生成uid的长度
     */
    private final int LENGTH_UID = 16;

    @Autowired
    private UserAdminMapper userDao;

    @Override
    public String registered(RegisteredParameterDTO param) {
        if(param.getEmail() == null || param.getUserName() == null || param.getPassword() == null) {
            return ResponseStatus.FAIL_PARAM_IS_NULL.getStatus();
        }
        if(userDao.selectHasUserEmail(param.getEmail()) == 1) {
            return ResponseStatus.FAIL_EMAIL_PARAM_SAME.getStatus();
        }
        String uid = Util.getRandomString(LENGTH_UID);
        String password = DigestUtils.md5DigestAsHex(param.getPassword().getBytes());
        // 注册初始化数据库
        userDao.addUserRecord(uid, param.getEmail(), password);
        userDao.addUserInfoBlankRecord(uid, param.getUserName());
        userDao.addUserLevelBlankRecord(uid);
        userDao.addUserMusicListILikeBlankRecord(uid);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public String loginAttest(String email, String password, Boolean isAutoLogin, HttpSession session) {
        if(email == null || password == null || isAutoLogin == null) {
            return ResponseStatus.FAIL_PARAM_IS_NULL.getStatus();
        }
        // 邮箱+密码检查
        if(userDao.selectHasUserEmailAndPassword(email, password) == 0) {
            return ResponseStatus.FAIL_LOGIN_INFO_ERROR.getStatus();
        }
        // 登录成功后将用户uid放入session中
        String uid = userDao.getUidByAccount(email);
        session.setAttribute("uid", uid);
        // 勾选免登录->延长销毁时间
        if(isAutoLogin) {
            session.setMaxInactiveInterval(AUTO_LOGIN_SESSION_TIME);
        }
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public String loginExit(HttpSession session) {
        session.invalidate();
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public boolean isTodayFirstLogin(String uid) {
        Date lastLoginTime = userDao.selectUserLastLoginTime(uid);
        Date currentTime = new Date();
        DateFormat dfm = DateFormat.getDateInstance();
        if(dfm.format(currentTime).equals(dfm.format(lastLoginTime))) {
            return false;
        }
        return true;
    }

    @Override
    public void setFirstLoginCache(HttpServletResponse resp) {
        Cookie firstCache = new Cookie("firstCache", "true");
        // 当天晚上23:59:59减去当前时间，即为cache的存活时间
        long overTime = Util.getOneDayEndTime();
        long cut = System.currentTimeMillis();
        int cookieTime = Math.toIntExact(overTime - cut);
        firstCache.setMaxAge(cookieTime);
        resp.addCookie(firstCache);
    }

    @Override
    public void replaceLoginTime(String uid) {
        userDao.updateUserLastLoginTime(uid);
    }

}
