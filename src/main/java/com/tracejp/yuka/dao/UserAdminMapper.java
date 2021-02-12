package com.tracejp.yuka.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.Map;

/*********************************
 * @author traceJP
 *********************************/
public interface UserAdminMapper {

    /**
     * 向User表中添加一条完整的记录
     * @param param
     */
    void addUserRecord(Map<String, Object> param);

    /**
     * 查询User表中是否有对应的email记录
     * @param email
     * @return 存在返回1 不存在返回0
     */
    int selectHasUserEmail(@Param("email") String email);

    /**
     * 查询User表中对应的账号密码是否匹配
     * @param email
     * @param password
     * @return 存在返回1 不存在返回0
     */
    int selectHasUserEmailAndPassword(@Param("email") String email, @Param("password") String password);

    /**
     * 通过email获得对应的用户唯一标识uid
     * @param email 账号
     * @return uid
     */
    String getUidByAccount(String email);

    /**
     * 通过uid获取用户昵称
     * @param uid
     */
    String selectUserName(@Param("uid") String uid);

    /**
     * 查询用户最后登录时间
     * @param uid uid
     * @return 登录时间YYYY-MM-DD HH:MM:SS
     */
    Date selectUserLastLoginTime(@Param("uid") String uid);

    /**
     * 修改用户最后登录时间为当前时间
     * @param uid uid
     */
    void updateUserLastLoginTime(@Param("uid") String uid);


    /**
     * 根据uid修改对应的邮箱
     * @param uid
     * @param newEmail
     */
    void updateEmail(@Param("uid") String uid, @Param("newEmail") String newEmail);

    /**
     * 根据uid修改对应的密码
     * @param uid
     * @param newPassword
     */
    void updatePassword(@Param("uid") String uid, @Param("newPassword") String newPassword);

    /**
     * 根据uid修改对应的昵称
     * @param uid
     * @param newName
     */
    void updateName(@Param("uid") String uid, @Param("newName") String newName);

    /**
     * 根据uid修改对应的性别
     * @param uid
     * @param newSex
     */
    void updateSex(@Param("uid") String uid, @Param("newSex")  String newSex);

    /**
     * 根据uid修改对应的生日
     * @param uid
     * @param newBirthday
     */
    void updateBirthday(@Param("uid") String uid, @Param("newBirthday") Date newBirthday);

    /**
     * 通过uid查询对应的用户头像
     * @param uid
     * @return
     */
    String selectAvatar(@Param("uid") String uid);

    /**
     * 根据uid修改对应的头像
     * @param uid
     * @param newAvatarUrl
     */
    void updateAvatar(@Param("uid") String uid, @Param("newAvatarUrl") String newAvatarUrl);

    /**
     * 根据uid修改对应的个人介绍
     * @param uid
     * @param newIntroduction
     */
    void updateIntroduction(@Param("uid") String uid, @Param("newIntroduction") String newIntroduction);

    /**
     * 根据uid修改对应的所在地区
     * @param uid
     * @param newArea
     */
    void updateArea(@Param("uid") String uid, @Param("newArea") String newArea);

}
