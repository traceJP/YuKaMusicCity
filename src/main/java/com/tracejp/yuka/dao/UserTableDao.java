package com.tracejp.yuka.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

/*********************************
 * @author traceJP
 *********************************/
public interface UserTableDao {

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
     * 根据uid修改对应的密码
     * @param uid
     * @param newPassword
     */
    void updatePassword(@Param("uid") String uid, @Param("newPassword") String newPassword);

}
