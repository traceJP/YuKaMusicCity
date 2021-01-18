package com.tracejp.yuka.service.impl;

import com.tracejp.yuka.dao.UserTableDao;
import com.tracejp.yuka.model.enums.ResponseStatus;
import com.tracejp.yuka.model.pojo.LoginParameterObject;
import com.tracejp.yuka.model.pojo.RegisteredParameterObject;
import com.tracejp.yuka.service.UserAdminService;
import com.tracejp.yuka.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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
    private final int lengthToUID = 16;

    @Autowired
    private UserTableDao userDao;

    public int registered(RegisteredParameterObject param) {
        if(param.getEmail() == null || param.getUserName() == null || param.getPassword() == null) {
            return ResponseStatus.FAIL_PARAM_IS_NULL.getStatus();
        }
        if(hasEmail(param.getEmail())) {
            return ResponseStatus.FAIL_EMAIL_PARAM_SAME.getStatus();
        }
        String uid = Util.getRandomString(lengthToUID);
        String password = DigestUtils.md5DigestAsHex(param.getPassword().getBytes());
        Map<String, Object> map = new HashMap<String, Object>(4);
        map.put("uid", uid);
        map.put("name", param.getUserName());
        map.put("email", param.getEmail());
        map.put("password", password);
        // 注册
        userDao.addUserRecord(map);


        return 0;

    }

    public int loginAttest(LoginParameterObject param) {
        return 0;
    }

    public int updatePassword(String password) {
        return 0;
    }

    public void setUserTokenSession(String uid, String password) {

    }

    public void clearTokenSession(String uid) {

    }

    /**
     * 是否存在相同的email记录
     * @param email email字段
     * @return 存在则返回true
     */
    private boolean hasEmail(String email) {
        return email.equals(userDao.selectUserEmail(email));
    }


}
