package com.tracejp.yuka.service.admin.impl;

import com.tracejp.yuka.dao.UserAdminMapper;
import com.tracejp.yuka.model.enums.ResponseStatus;
import com.tracejp.yuka.service.admin.UserUpdateService;
import com.tracejp.yuka.utils.LocalFileCommandUtil;
import com.tracejp.yuka.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/*********************************
 * @author traceJP
 *********************************/
@Service
public class UserUpdateServiceImpl implements UserUpdateService {

    @Autowired
    private UserAdminMapper userDao;

    @Autowired
    private LocalFileCommandUtil.Builder fileSave;

    @Override
    public String updateUserEmail(String uid, String newEmail) {
        if(userDao.selectHasUserEmail(newEmail) == 1) {
            return ResponseStatus.FAIL_EMAIL_PARAM_SAME.getStatus();
        }
        userDao.updateEmail(uid, newEmail);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public String updateUserPassword(String uid, String oldPassword, String newPassword) {
        // 分别加密oldPassword和newPassword
        String oldPasswordMD5 = DigestUtils.md5DigestAsHex(oldPassword.getBytes());
        String newPasswordMD5 = DigestUtils.md5DigestAsHex(newPassword.getBytes());
        int count = userDao.selectHasUserIdAndPassword(uid, oldPasswordMD5);
        if(count == 0) {
            return ResponseStatus.SUCCESS_ERROR.getStatus();
        }
        userDao.updatePassword(uid, newPasswordMD5);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public String updateUserName(String uid, String newName) {
        userDao.updateName(uid, newName);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public String updateUserSex(String uid, String newSex) {
        userDao.updateSex(uid, newSex);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public String updateUserBirthday(String uid, String newBirthday) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(newBirthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userDao.updateBirthday(uid, date);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public String updateUserAvatar(String uid, MultipartFile newAvatarFile) {
        if(newAvatarFile == null) {
            return ResponseStatus.SUCCESS_ERROR.getStatus();
        }
        // 获取本地绝对路径前缀
        String absoluteUrl = null;
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties(
                    "properties/LocalFileUrlConfig.properties"
            );
            absoluteUrl = properties.getProperty("localURL");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 删除本地原始图片
        String localOldFileUrl = userDao.selectAvatar(uid);
        if(localOldFileUrl != null) {
            File oldFile = new File(absoluteUrl + localOldFileUrl);
            if(!oldFile.delete()) {
                return ResponseStatus.SUCCESS_ERROR.getStatus();
            }
        }
        // 新增图片到本地
        String localUrl = null;
        try {
            LocalFileCommandUtil fileObj = fileSave.builderMultipartFile(newAvatarFile)
                    .builderConfigKey("userImgUrl")
                    .builderFileName(Util.getRandomString(16))
                    .builder();
            fileObj.saveFile();
            localUrl = fileObj.getFileRelativelyUrl();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(localUrl == null) {
            return ResponseStatus.SUCCESS_ERROR.getStatus();
        }
        // 修改数据库记录
        userDao.updateAvatar(uid, localUrl);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public String updateUserIntroduction(String uid, String newIntroduction) {
        userDao.updateIntroduction(uid, newIntroduction);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

    @Override
    public String updateUserArea(String uid, String newArea) {
        userDao.updateArea(uid, newArea);
        return ResponseStatus.SUCCESS_200.getStatus();
    }

}
