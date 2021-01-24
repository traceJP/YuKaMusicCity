package com.tracejp.yuka.service.impl;

import com.tracejp.yuka.dao.UserTableMapper;
import com.tracejp.yuka.model.enums.ResponseStatus;
import com.tracejp.yuka.model.dto.RegisteredParameterDTO;
import com.tracejp.yuka.service.UserAdminService;
import com.tracejp.yuka.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
    private UserTableMapper userDao;

    public String registered(RegisteredParameterDTO param) {
        if(param.getEmail() == null || param.getUserName() == null || param.getPassword() == null) {
            return ResponseStatus.FAIL_PARAM_IS_NULL.getStatus();
        }
        if(userDao.selectHasUserEmail(param.getEmail()) == 1) {
            return ResponseStatus.FAIL_EMAIL_PARAM_SAME.getStatus();
        }
        String uid = Util.getRandomString(LENGTH_UID);
        String password = DigestUtils.md5DigestAsHex(param.getPassword().getBytes());
        Map<String, Object> map = new HashMap<String, Object>(4);
        map.put("uid", uid);
        map.put("name", param.getUserName());
        map.put("email", param.getEmail());
        map.put("password", password);
        // 注册
        userDao.addUserRecord(map);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

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

    public String updatePassword(String uid, String password) {
        if(uid == null || password == null) {
            return ResponseStatus.FAIL_PARAM_IS_NULL.getStatus();
        }
        userDao.updatePassword(uid, password);
        return ResponseStatus.SUCCESS_200.getStatus();
    }




}
