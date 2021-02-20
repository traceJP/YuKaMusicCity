package com.tracejp.yuka.service.admin;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/*********************************
 * @author traceJP
 *********************************/
public interface UserUpdateService {

    /**
     * 邮箱修改服务
     * @param uid
     * @param newEmail
     * @return
     */
    String updateUserEmail(String uid, String newEmail);

    /**
     * 密码修改服务
     * @param oldPassword 旧密码
     * @param newPassword 前端传递密码参数
     * @param uid
     * @return 返回一个响应状态码
     */
    String updateUserPassword(String uid, String oldPassword, String newPassword);

    /**
     * 昵称修改服务
     * @param uid
     * @param newName
     * @return
     */
    String updateUserName(String uid, String newName);

    /**
     * 性别修改服务
     * @param uid
     * @param newSex
     * @return
     */
    String updateUserSex(String uid, String newSex);

    /**
     * 生日修改服务
     * @param uid
     * @param newBirthday
     * @return
     */
    String updateUserBirthday(String uid, String newBirthday);

    /**
     * 头像修改服务
     * @param uid
     * @param newAvatarFile
     * @return
     */
    String updateUserAvatar(String uid, MultipartFile newAvatarFile);

    /**
     * 个人简介修改服务
     * @param uid
     * @param newIntroduction
     * @return
     */
    String updateUserIntroduction(String uid, String newIntroduction);

    /**
     * 所在地区修改服务
     * @param uid
     * @param newArea
     * @return
     */
    String updateUserArea(String uid, String newArea);

}
